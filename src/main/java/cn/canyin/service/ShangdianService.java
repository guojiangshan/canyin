package cn.canyin.service;


import cn.canyin.model.Shangdian;

public interface ShangdianService {
	//private static Logger logger = Logger.getLogger(Shan);
	public Shangdian getShagndianBySdID(Long sd_id) throws Exception;
	public Shangdian getShangdianBySDWXID(String sd_wxid) throws Exception;
	public Long addShangdian(Shangdian shangdian) throws Exception;
}
