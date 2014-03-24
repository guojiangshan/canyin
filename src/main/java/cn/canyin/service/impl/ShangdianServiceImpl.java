package cn.canyin.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.canyin.dao.ShangdianDao;
import cn.canyin.model.Shangdian;
import cn.canyin.service.ShangdianService;

public class ShangdianServiceImpl implements ShangdianService {

	private static Logger logger = Logger.getLogger(ShangdianServiceImpl.class);
	@Autowired
	private ShangdianDao shangdianDao;
	
	@Override
	public Shangdian getShagndianBySdID(Long sd_id) throws Exception {
		// TODO Auto-generated method stub
		return shangdianDao.findById(sd_id);
	}

	@Override
	public Shangdian getShangdianBySDWXID(String sd_wxid) throws Exception {
		// TODO Auto-generated method stub
		return shangdianDao.findByWeixinId(sd_wxid);
	}

	@Override
	public Long addShangdian(Shangdian shangdian) throws Exception {
		// TODO Auto-generated method stub
		return shangdianDao.add(shangdian);
	}
	
	
	
}
