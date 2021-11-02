package com.zh.model;

import java.util.*;
import java.sql.*;

public class UserBeanBo {

	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//�û�������һ���û���ȫ����Ϣ
	public UserBean getUserBean (String username){
		
		
		UserBean ub=new UserBean();
		
		try {
			
			
			String sql="select * from users where username=?";
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				ub.setUserid(rs.getInt(1));
				ub.setUsername(rs.getString(2));
				ub.setTruename(rs.getString(3));
				ub.setPasswd(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setPostcode(rs.getString(8));
				ub.setGrade(rs.getInt(9));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return ub;
	}
	
	
	//�û���¼��֤
	
	public boolean checkUser(String u,String p){
		
		boolean b=false;
		try {
			
			String sql="select passwd from users where username=?";
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement(sql);
			ps.setString(1, u);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				
				//�õ����ݿ��е�����
				String passwd=rs.getString(1);
				if(passwd.equals(p)){
					
					b=true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
	}
	
//	�ر���Դ
	public void close(){
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs=null;
			}
			if(ps!=null){
				
				ps.close();
				ps=null;
			}
			if(ct!=null){
				
				ct.close();
				ct=null;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
