package com.test.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class Parameter {
	
		// 获取项目路径(获取本项目路径)
	    String filePath = System.getProperty("user.dir");
		//创建读取字符流
		public FileInputStream fis;
		//声明字符流编码格式
	    public InputStreamReader reader;
	    //创建properties对象
	    public Properties pro;
	    
	    public void proInit(String fileName)throws IOException {
	    	// 获取项目路径(获取本项目路径)
		    String filePath = System.getProperty("user.dir");
			//创建读取字符流
			fis = new FileInputStream(filePath + "/src/main/resources/"+fileName+".properties");
			//声明字符流编码格式
			reader = new InputStreamReader(fis,"UTF-8");
			 //创建properties对象
			pro = new Properties();
			//读取的文件加入properties对象中
			pro.load(reader);
	    }
	
	   // 读取properties文件
		public String obtain(String key,String fileName) throws IOException {
			proInit(fileName);
			//获取值
			String value = pro.getProperty(key);
			fis.close();
			reader.close();
			return value;
		}
		
		//获取properties文件的所有键值
		public Iterator<Entry<Object, Object>> getKeyValue(String fileName) throws IOException {
			proInit(fileName);
			if(fileName.equals("search")) {
				Iterator<Entry<Object, Object>>  ite= pro.entrySet().iterator();
					return ite;
			}
			return null;
		}
   }
