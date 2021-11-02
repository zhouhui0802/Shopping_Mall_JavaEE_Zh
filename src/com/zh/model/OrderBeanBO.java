package com.zh.model;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class OrderBeanBO {
//	定义一些变量[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	public static int temp=1;
	
	
	/**
	 * 生成订单
	 * @param mbo 用户的购物车
	 * @param userId 用户 id
	 * @return 返回一个订单详细信息bean【OrderInfoBean】
	 */
	
	public int countNumber()
	{
		try {
			
			//真的代码..
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select count(*) from orders");
			rs=ps.executeQuery();
			while(rs.next())
			{
				temp=rs.getInt(1);
			}
  			temp=temp+1;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		System.out.println("temp="+temp);
		return temp;
	}
	
	
	public OrderInfoBean addOrder(MyCart mbo,String userId){
		
		OrderInfoBean oib=new OrderInfoBean();
		boolean b=true;
		try {
			
			//真的代码..
			
			ct=new ConnDB().getConn();
			
			Date date=new Date();
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String dateTemp=formatter.format(date);
			int tempAdd=countNumber();
			ps=ct.prepareStatement("insert into orders (ordersId,userId,orderData,payMode,isPayed,totalPrice)  values(?,?,?,?,?,?)");
			ps.setLong(1, tempAdd);
			ps.setString(2, userId);
			ps.setString(3, dateTemp);
			ps.setLong(4, 0);
			ps.setByte(5, (byte)0);
			ps.setFloat(6, mbo.getAllPrice());
			
			//执行
			int a=ps.executeUpdate();
			
			if(a==1){
				
				System.out.println("插入orders成功");
				//必须取出刚刚添加到orders表的那个订单号
				//取出最后那条的orders的id就是
				
				ps=ct.prepareStatement("select max(ordersId) from orders");
				
				rs=ps.executeQuery();
				
				int orderId=0;
				if(rs.next()){
					
					orderId=rs.getInt(1);
					
				}
				
				
				//orders表添加ok
				//添加ordersDetail表
				
				//从购物车中取出所有选购的商品
				ArrayList al=mbo.showAllMyCart();
				
				//循环的添加到orderDetail表//!!!
				//我们可以使用批量操作数据库的方法，提供操作数据库的效率.
				Statement sm=ct.createStatement();
				for(int i=0;i<al.size();i++){
					
					GoodsBean gb=(GoodsBean)al.get(i);
					sm.addBatch("insert into orderDetail values('"+orderId+"','"+gb.getGoodsId()+"','"+mbo.getGoodsNumById(gb.getGoodsId()+"")+"')");
					
				}
				
				//批量执行添加任务呢
				sm.executeBatch();
				
				System.out.println("批量插入执行成功");
				
				//多表查询,
				String sql="select ordersId ,truename,address,postcode,phone,totalPrice,username,email from users,orders"+ 
				" where ordersId=? and users.userid = (select orders.userid from orders where ordersId=?)";
				
				
				ps=ct.prepareStatement(sql);
				ps.setInt(1,orderId);
				ps.setInt(2,orderId );
				System.out.println(sql);
				rs=ps.executeQuery();
				
				if(rs.next()){
					
					//将rs封装到OrderInfoBean
					oib.setOrdersId(rs.getInt(1));
					oib.setTruename(rs.getString(2));
					oib.setAddress(rs.getString(3));
					oib.setPostcode(rs.getString(4));
					oib.setPhone(rs.getString(5));
					oib.setTotalPrice(rs.getFloat(6));
					oib.setUsername(rs.getString(7));
					oib.setEmail(rs.getString(8));
					
				}
				
			}
			
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//关闭资源
			this.close();
		}
		
		if(b){
		System.out.println("执行到判断的最后一步");	
		return oib;
		
		}else{
			return null;
		}
	}
	
	
//关闭函数
	
	public void close(){
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs=null;//
			}
			if(ps!=null){
				
				ps.close();
				ps=null;
			}
			
			if(!ct.isClosed()){
				
				ct.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
