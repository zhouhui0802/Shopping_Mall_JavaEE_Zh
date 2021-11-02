package com.zh.model;
import java.sql.*;
import java.util.*;

public class GoodsBeanBo {
	
	//������Ʒ��ҵ���߼�   �����ݿ����ֱ�����
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	private int  pageSize=6;
	private int  rowCount=0;//��ֵ�����ݿ��ѯ
	private int  pageCount=0;//��ֵ��ͨ��pageSize��rowCount
	
	
	//����id�õ��������Ϣ
	public GoodsBean getGoodsBeanById(String id){
		
		GoodsBean gb=new GoodsBean();
		
		try {
			
			//�õ�����
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select * from goods where goodsId=?");
			ps.setString(1, id);
			// ��ѯ
  			rs=ps.executeQuery();
  			
  			if(rs.next()){
  				
  				gb.setGoodsId(rs.getInt(1));
  				gb.setGoodsName(rs.getString(2));
  				gb.setGoodsIntro(rs.getString(3));
  				gb.setGoodsPrice(rs.getFloat(4));
  				gb.setGoodsNum(rs.getInt(5));
  				gb.setPublisher(rs.getString(6));
  				gb.setPhoto(rs.getString(7));
  				gb.setGoodsType(rs.getString(8));
  			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return gb;
		
	}
	
//	���أ���ҳ����ҳ��
	public int getPageCount(){
		
		//...
		try {
			
			//�õ�����
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select count(*) from goods ");
//			4. ��ѯ
  			rs=ps.executeQuery();
   
   			//��ע�⣬һ��Ҫrs.next(),��Ȼ��Ͳ���
   			
   			if(rs.next()){	
   				rowCount=rs.getInt(1);
   			}
   			
   			//����pageCount,�����㷨�ܶ࣬�����Լ����
   			if(rowCount%pageSize==0){
   				
   				pageCount=rowCount/pageSize;
   			}else{
   				
   				pageCount=rowCount/pageSize+1;
   			}
			//����pageCount..
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return pageCount;
	}
	
	//��ҳ��ʾ
	public ArrayList showGoodsByPage(int pageSize,int pageNow){
		
		ArrayList al=new ArrayList();
		
		try {
			
			ct=new ConnDB().getConn();
			
			
			//���ڷ�ҳ��ʾ
			ps=ct.prepareStatement("select * from goods limit "+pageSize*(pageNow-1)+","+pageSize*pageNow);
			System.out.println("select * from goods limit "+pageSize*(pageNow-1)+","+pageSize*pageNow);
			rs=ps.executeQuery();
			
			
			while(rs.next()){
				
				
				GoodsBean gb=new GoodsBean();
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				
				al.add(gb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return al;
		
		
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
