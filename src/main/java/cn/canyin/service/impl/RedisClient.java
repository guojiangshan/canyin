package cn.canyin.service.impl;
import java.util.List;
import java.util.Map;

import cn.canyin.service.RedisService;

/**
 * @author Fidel
 * @since 2012-07-19
 * @see RedisService
 */

public class RedisClient {
	
	public  void put(String key ,Object obj){
		//set(key, obj, null);
		RedisService.put(key, obj, null);
	}
	
	public  void put(String key ,Object obj,Integer second){
		//set(key, obj, second);
		RedisService.put(key, obj, second);
	}
	
	/**
	 * 从 redis 里去掉一个 kye/value 对
	 * @param key
	 */
	public void delete(String key) {
		//this.redisTemplate.delete(key);
		RedisService.delete(key);
	}
	
	public int Incr(String key, Integer second) {  
	       Object value = get(key);  
           Integer valueRef = (value == null) ? 1 : (Integer) value;  
	       put(key, valueRef+1,second);  
		   return valueRef;  
	}  
	/**
	 * @param key
	 * @return Object if found otherwise return null
	 */
	public   Object get(final String key) {
		
		return RedisService.get(key);
		
		/*return redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] _b = connection.get(ByteToObjectUtils.ObjectToByte(key));
				if(_b==null){
					return null;
				}else{
					return ByteToObjectUtils.ByteToObject(_b);
				}
			}
		});*/
	}
	/*
	private  void set(final String key ,final Object obj,final  Integer second){
		RedisService.put(key, obj, second);
		try{
			if(key==null || obj == null ){
				throw new Exception("key or value must not null");
			}
			if(!(key instanceof  java.io.Serializable) || !(obj instanceof  java.io.Serializable)){
				throw new Exception("key or value must is instanceof java.io.Serializable ");
			}
			 redisTemplate.execute(new RedisCallback<Object>() {   
		           @Override  
		           public Object doInRedis(RedisConnection connection) throws DataAccessException {   
		        	   byte[] _key = ByteToObjectUtils.ObjectToByte(key);
		        	   connection.set( _key,ByteToObjectUtils.ObjectToByte(obj));
		        	   // 设置有效期
		        	   if(second!=null && second>0){
		        		   connection.expire(_key, second);
		        	   }
		               return true;   
		           }   
		       });
		}catch(Exception e){
			logger.error("RedisClient#put"+e);
		}
	}*/
	
	/**
	 * 账户动态set 数据
	 * @param data
	 */
	public  void setDynamicByList(List<Map<String, String>> data){
		for(Map<String, String> map: data){
			setDynamic(Long.parseLong(map.get("userId")), map);
		}	
	}
	/**
	 * 账户动态set 数据
	 * @param data
	 */
	public  void setDynamic(Long userId, Map<String, String> data){
//     /////////账户充提//////////		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("time", "2012/122/12");    需要格式化
//		map.put("content", "账户充值");
//		map.put("status", "充值成功");
//		map.put("type", "1");
//		map.put("amount", "5000");
//		map.put("bank", "建设银行");
//		map.put("bankCard", "6222 **** **** **** 22222");
//		map.put("action", "1"); // 1 入账，-1出账
//		/////////认证提交//////////
//		map = new HashMap<String, String>();
//		map.put("time", "2013/12/12");
//		map.put("content", "不动产认证 ");
//		map.put("type", "2");
//		map.put("status", "-1"); //  1 审核通过，-1审核未通过
//		/////////还款信息///////
//		map = new HashMap<String, String>();
//		map.put("time", "2012/12/12");
//		map.put("type", "3");
//		map.put("content", "您的一笔借款即将到期");
//		map.put("orderId", "227");
//		map.put("outAmount", "3200");
//		map.put("expires", "2012/12/10");
//		//////// 收款提示////////		
//		map = new HashMap<String, String>();
//		map.put("time", "2012/12/12");
//		map.put("type", "4");
//		map.put("content", "您收到一笔用户还款");
//		map.put("orderId", "227");
//		map.put("inAmount", "3200");
//		map.put("collectionTime", "2012/12/10");
		  RedisService.setDynamic(userId, data);
	}
	
	/**
	 * 账户动态get 数据
	 * @param currentPage
	 * @param perNum
	 * @return
	 */
	public  String getDynamic(Long userId, Integer currentPage, Integer perNum) {
		return RedisService.getDynamic(userId, currentPage, perNum);
	}
	
	/**
	 * 账户动态del数据
	 * @param key
	 */
	public  void delDynamic(Long userId, String key){
		RedisService.delDynamic(userId, key);
	}
	
	public  long llen(String key){
		return RedisService.llen(key);
	}
}
