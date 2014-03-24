package cn.canyin.dao;

import org.apache.log4j.Logger;

public class BaseDao {
	protected static Logger logger = Logger.getLogger(BaseDao.class);
	private org.mybatis.spring.SqlSessionTemplate sqlSessionWriter;
	private org.mybatis.spring.SqlSessionTemplate sqlSessionRead;
	public org.mybatis.spring.SqlSessionTemplate getSqlSessionWriter() {
		return sqlSessionWriter;
	}
	public void setSqlSessionWriter(
			org.mybatis.spring.SqlSessionTemplate sqlSessionWriter) {
		this.sqlSessionWriter = sqlSessionWriter;
	}
	public org.mybatis.spring.SqlSessionTemplate getSqlSessionRead() {
		return sqlSessionRead;
	}
	public void setSqlSessionRead(
			org.mybatis.spring.SqlSessionTemplate sqlSessionRead) {
		this.sqlSessionRead = sqlSessionRead;
	}
	public org.mybatis.spring.SqlSessionTemplate getSqlSession(String ...type) {
		if(type!=null && type.length==1){
			String _type = type[0];
			if(SqlSessionType.READ.equals(_type)){
				return sqlSessionRead;
			}
			else if(SqlSessionType.WRITER.equals(_type)){
				return sqlSessionWriter;
			}else{
				return sqlSessionWriter;
			}
		}else{
			return sqlSessionWriter;
		}
	}
}
