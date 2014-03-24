package cn.canyin.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

public class ByteToObjectUtils {
	private static Logger logger = Logger.getLogger(ByteToObjectUtils.class);
    public static byte[] ObjectToByte(java.lang.Object obj) {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream bo= null;
        ObjectOutputStream oo =null;
        try {
            // object to bytearray
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
            bo.close();
            oo.close();
        } catch (Exception e) {
        	logger.error(e);
        	return null;
        }finally{
        	try{
        		if(oo!=null){
            		oo.close();
            	}if(bo!=null){
            		bo.close();
            	}
        	}catch(Exception e){
        		logger.error("ByteToObjectUtils.ObjectToByte close stream encounted a error ",e);
        	}
        }
        return (bytes);
    }

    public static Object ByteToObject(byte[] bytes) {
        java.lang.Object obj = new java.lang.Object();
        ByteArrayInputStream bi= null;
        ObjectInputStream oi =null;
        try {
            // bytearray to object
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);
            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
        	logger.error(e);
        	return null;
        }finally{
        	try{
        		if(oi!=null){
            		oi.close();
            	}if(bi!=null){
            		bi.close();
            	}
        	}catch(Exception e){
        		logger.error("ByteToObjectUtils.ByteToObject close stream encounted a error ",e);
        	}
        }
        return obj;
    }
}
