package cn.canyin.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.canyin.dao.BaseDao;
import cn.canyin.dao.ShangdianDao;
import cn.canyin.model.Shangdian;
import cn.canyin.service.impl.RedisClient;


public class ShangdianDaoImpl extends BaseDao implements ShangdianDao {

	private static Logger logger = Logger.getLogger(ShangdianDaoImpl.class);
	private RedisClient redisClient;
	
	@Override
	public Shangdian findById(long sd_id) throws Exception {
		// TODO Auto-generated method stub
		
		return (Shangdian)this.getSqlSessionWriter().selectOne("cn.canyin.model.Shangdian.queryById", sd_id);
	}

	

	@Override
	public Shangdian findByWeixinId(String sd_weixinid) throws Exception {
		// TODO Auto-generated method stub
		return (Shangdian)this.getSqlSessionWriter().selectOne("cn.canyin.model.Shangdian.queryByWXId", sd_weixinid);
	}

	@Override
	public long add(Shangdian sd) throws Exception {
		// TODO Auto-generated method stub
		try{
			 return this.getSqlSessionWriter().insert("cn.canyin.model.Shangdian.insertShangdian", sd);
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}

	
	public RedisClient getRedisClient() {
		return redisClient;
	}

	public void setRedisClient(RedisClient redisClient) {
		this.redisClient = redisClient;
	}
	
}
