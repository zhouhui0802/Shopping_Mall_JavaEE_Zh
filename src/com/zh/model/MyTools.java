package com.zh.model;

public class MyTools {
	//ת����������
	public static String changeToGB2312(String srcString){
		
		String newString="";
		try {
			
			newString=new String(srcString.getBytes("iso-8859-1"),"gb2312");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return newString;
	}
}
