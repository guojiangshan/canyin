package cn.canyin.constant;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class CanyinConfig {
	private static Logger logger  = Logger.getLogger(CanyinConfig.class);
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("canyinConfig");
	public static String getValue(String key,Object ...params){
		try{
			if(params!=null && params.length==0){
				return resourceBundle.getString(key);
			}else{
				return  MessageFormat.format(resourceBundle.getString(key), params);
			}
		}catch(Exception e){
			logger.warn("Can't find resource for bundle java.util.PropertyResourceBundle, key '"+key+"' , and method will return null");
			return null;
		}
	}
	/*
	private static ResourceBundle rsaResourceBundle = ResourceBundle.getBundle("RSA");
	public static String getRSAValue(String key,Object ...params){
		try{
			if(params!=null && params.length==0){
				return rsaResourceBundle.getString(key);
			}else{
				return  MessageFormat.format(rsaResourceBundle.getString(key), params);
			}
		}catch(Exception e){
			logger.error("will return null",e);
			return null;
		}
	}	*/
	public static void main(String[] args) {
//		System.out.println(resourceBundle.getString("auditIdXmlFormat"));
		//System.out.println(getValue("hftx.merId"));
		System.out.println(getValue("fileUploadRoot"));
//		System.out.println(getRSAValue("publicModulus",""));
	}
}
