package cn.canyin.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import cn.canyin.constant.CanyinConfig;
import cn.canyin.util.ByteToObjectUtils;
import cn.canyin.util.PageBean;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisService {
	private static JedisPool pool;
	private static Logger logger  = Logger.getLogger(RedisService.class);
	static {
		System.out.println("redis.server.ip=" + CanyinConfig.getValue("redis.server.ip"));
		System.out.println("redis.server.port=" + CanyinConfig.getValue("redis.server.port"));
		System.out.println("open_api_server_ip=" + CanyinConfig.getValue("open_api_server_ip"));
		System.out.println("open_api_server_timeout=" + CanyinConfig.getValue("open_api_server_timeout"));
		System.out.println("db.master.url=" + CanyinConfig.getValue("db.master.url"));
		System.out.println("fileUploadRoot=" + CanyinConfig.getValue("fileUploadRoot"));
		System.out.println("db.master.user=" + CanyinConfig.getValue("db.master.user"));
		System.out.println("beanstalk.host=" + CanyinConfig.getValue("beanstalk.host"));
		System.out.println("beanstalk.port=" + CanyinConfig.getValue("beanstalk.port"));
		
		logger.info("redis.server.ip=" + CanyinConfig.getValue("redis.server.ip"));
		logger.info("redis.server.port=" + CanyinConfig.getValue("redis.server.port"));
		logger.info("open_api_server_ip=" + CanyinConfig.getValue("open_api_server_ip"));
		logger.info("open_api_server_timeout=" + CanyinConfig.getValue("open_api_server_timeout"));
		logger.info("db.master.url=" + CanyinConfig.getValue("db.master.url"));
		logger.info("fileUploadRoot=" + CanyinConfig.getValue("fileUploadRoot"));
		logger.info("db.master.user=" + CanyinConfig.getValue("db.master.user"));
		logger.info("beanstalk.host=" + CanyinConfig.getValue("beanstalk.host"));
		logger.info("beanstalk.port=" + CanyinConfig.getValue("beanstalk.port"));
		
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(Integer.valueOf(CanyinConfig.getValue("redis.pool.maxActive")));
		config.setMaxIdle(Integer.valueOf(CanyinConfig.getValue("redis.pool.maxIdle")));
		config.setMaxWait(Integer.valueOf(CanyinConfig.getValue("redis.pool.maxWait")));
		pool = new JedisPool(config, CanyinConfig.getValue("redis.server.ip"),
				Integer.valueOf(CanyinConfig.getValue("redis.server.port")));
	}

	/**
	 * 从连接池获取
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		return pool.getResource();
	}

	/**
	 * 返回给连接池
	 * @param jedis
	 */
	public static void closeJedis(Jedis redis) {

			pool.returnResource(redis);

	}
	/**
	 * add by jonsan guo 
	 * */
	public static void closeJedis(JedisPool pool, Jedis redis) {
		if(redis!=null){
			pool.returnResource(redis);
		}
	}

  public static Long push(String key, Object value) {
		Jedis jedis = pool.getResource();
		try {
			return jedis.rpush(key.getBytes(), ByteToObjectUtils.ObjectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.returnResource(jedis);
		}
		return null;
	}

	public static Object pop(String key) {
		Jedis jedis = pool.getResource();
		byte[] result = null;
		try {
			 result = jedis.lpop(key.getBytes());
			 if(result!=null){
				 return ByteToObjectUtils.ByteToObject(result);
			 }else{
				 return null;
			 }
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public static void put(String key ,Object value,Integer timeout){
		Jedis jedis = null;
		try{
			 jedis = pool.getResource();
			 jedis.set(key.getBytes(), ByteToObjectUtils.ObjectToByte(value));
			 if(timeout!=null && timeout>0){
				 jedis.expire(key.getBytes(), timeout);
      	   }
		}catch(Exception e){
			logger.error("key="+key+",value="+value+",timeout="+timeout,e);
			logger.error("redis.server.ip="+CanyinConfig.getValue("redis.server.ip")+",redis.server.port="+CanyinConfig.getValue("redis.server.port"));
		}finally{
			closeJedis(jedis);
		}
	}
	
	public static Object get(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			byte[] obj = jedis.get(key.getBytes());
			if (obj != null) {
				return ByteToObjectUtils.ByteToObject(obj);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("key="+key,e);
			logger.error("redis.server.ip="+CanyinConfig.getValue("redis.server.ip")+",redis.server.port="+CanyinConfig.getValue("redis.server.port"));
			pool.returnBrokenResource(jedis);// add by jonsan
			//在instance出错时，必须调用returnBrokenResource返还给pool，否则下次通过getResource得到的instance的缓冲区可能还存在数据，出现问题！
			return null;
		} finally {
			closeJedis(jedis);
		}
	}
	
	public static void delete(String ...keys){
		Jedis jedis = null;
		try{
			 jedis = pool.getResource();
			 jedis.del(keys);
		}catch(Exception e){
			logger.error("keys="+keys,e);
			logger.error("redis.server.ip="+CanyinConfig.getValue("redis.server.ip")+",redis.server.port="+CanyinConfig.getValue("redis.server.port"));
		}finally{
			closeJedis(jedis);
		}
	}
	
	public static void  main (String [] args){
		
	}
	
	/**
	 * 账户动态set 数据
	 * @param data
	 */
	public static void setDynamic(Long userId, Map<String, String> data) {
		Jedis jedis = null;
		try{
			 jedis = pool.getResource();
			 String lkey = "l_dynamic"+userId;
			 long llen = jedis.llen(lkey);
			 // 每人最多为100条
			 if(llen>99) {
				 // 移除并返回列表 key 的尾元素
				String value = jedis.rpop(lkey);
				List<String> list = jedis.lrange("l_dynamic"+userId, 0, -1);
				// 移除表列表中所有与 value 相等的值 应为，type=3 key 为orderId，可能会有多条，不能直接删除hash 中的数据
				if(! list.contains(value)) {
					jedis.del(value);
				}
			 } 
			 String dynamicKey = "h_dynamic"+userId+"_";
			 if ("3".equals(data.get("type"))) {
				 dynamicKey +="oid"+data.get("orderId");
			 } else {
				 dynamicKey += jedis.incr("pkid");
			 }
			 jedis.hmset(dynamicKey, data);
			 jedis.lpush(lkey, dynamicKey);
			 // 新添加的动态
			 jedis.lpush("l_newDynamic"+userId, dynamicKey);
			 // TODO  过期时间将会去掉
//			 jedis.expire(dynamicKey, 6000);
//			 jedis.expire(lkey, 6000);
//			 jedis.expire("l_newDynamic"+userId, 6000);
		}catch(Exception e){
			logger.error("redis--->dynamic设值错误!",e);
		}finally{
			closeJedis(jedis);
		}				
	}
	
	/**
	 * 账户动态get 数据
	 * @param currentPage 当前页
	 * @param perNum 每页显示的条数
	 * @return
	 */
	public static String getDynamic(Long userId, Integer currentPage, Integer perNum) {
		ObjectMapper mapper = new ObjectMapper();
		PageBean pb = new PageBean();
		pb.setCurrentPage(currentPage);
		pb.setPerPageNum(perNum);
		Jedis jedis = null;
		try{
			    jedis = pool.getResource();
				List<Map<String, String >> list = new ArrayList<Map<String, String >>();
				List<String> value = jedis.lrange("l_dynamic"+userId, currentPage*perNum, (currentPage+1)*perNum-1);
				for (String key : value) {
					Map<String, String > _map =jedis.hgetAll(key);		
					list.add(_map);
				}
				pb.setCountRows(jedis.llen("l_dynamic"+userId));
				pb.setData(list);
				return mapper.writeValueAsString(pb);
		}catch(Exception e){
			logger.error("userId="+userId+",currentPage="+currentPage+",perNum="+perNum,e);
			return "-1";
		}finally{
			closeJedis(jedis);
		}			
	}
	
	/**
	 * 账户动态del数据
	 * @param currentPage 当前页
	 * @param perNum 每页显示的条数
	 * @return
	 */
	public static void delDynamic(Long userId, String key){
		Jedis jedis = null;
		try{
			 jedis = pool.getResource();	
			 jedis.del(key);
			 jedis.lrem("l_dynamic"+userId, 0, key);
		}catch(Exception e){
			logger.error(e);
		}finally{
			closeJedis(jedis);
		}					 
	}
	
	public static long llen(String key){
		Jedis jedis = null;
		try{
			 jedis = pool.getResource();	
			 return jedis.llen(key);
		}finally{
			closeJedis(jedis);
		}					 
	}
	
	public static void test(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("time",new Date().toString());
		map.put("content", "提示信息");
		map.put("status", "充值成功");
		map.put("type", "1");
		Jedis jedis = null;
		try{
			 jedis = pool.getResource();
			 String pk = "pkid"+jedis.incr("pkId");
			 jedis.hmset(pk, map);
			 jedis.expire(pk, 600);
			 jedis.lpush("pkey", pk);
			 jedis.expire("pkey", 600);
		}catch(Exception e){
			logger.error(e);
		}finally{
			closeJedis(jedis);
		}		
	}
	
	
	public static void del(){
		Jedis jedis = null;
		try{
			 jedis = pool.getResource();	
			 jedis.del("pkid5");
			 jedis.lrem("pkey", 0, "pkid5");
		}catch(Exception e){
			logger.error(e);
		}finally{
			closeJedis(jedis);
		}					 
	}
}
