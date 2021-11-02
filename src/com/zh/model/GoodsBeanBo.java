package com.zh.model;
import java.sql.*;
import java.util.*;

public class GoodsBeanBo {
	
	//处理物品的业务逻辑   与数据库操作直接相关
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	private int  pageSize=6;
	private int  rowCount=0;//该值从数据库查询
	private int  pageCount=0;//该值是通过pageSize和rowCount
	
	
	//根据id得到具体的信息
	public GoodsBean getGoodsBeanById(String id){
		
		GoodsBean gb=new GoodsBean();
		
		try {
			
			//得到连接
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select * from goods where goodsId=?");
			ps.setString(1, id);
			// 查询
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
	
//	返回，分页的总页数
	public int getPageCount(){
		
		//...
		try {
			
			//得到连接
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select count(*) from goods ");
//			4. 查询
  			rs=ps.executeQuery();
   
   			//请注意，一定要rs.next(),不然你就惨了
   			
   			if(rs.next()){	
   				rowCount=rs.getInt(1);
   			}
   			
   			//计算pageCount,这里算法很多，可以自己设计
   			if(rowCount%pageSize==0){
   				
   				pageCount=rowCount/pageSize;
   			}else{
   				
   				pageCount=rowCount/pageSize+1;
   			}
			//计算pageCount..
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return pageCount;
	}
	
	//分页显示
	public ArrayList showGoodsByPage(int pageSize,int pageNow){
		
		ArrayList al=new ArrayList();
		
		try {
			
			ct=new ConnDB().getConn();
			
			
			//用于分页显示
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
	
	//	关闭资源
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
