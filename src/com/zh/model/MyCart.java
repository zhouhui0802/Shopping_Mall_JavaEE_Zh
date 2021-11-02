package com.zh.model;

import java.util.*;
import java.sql.*;

public class MyCart {
	
	private HashMap hm=new HashMap();
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private float allPrice=0.0f;
	
	
	
	//ͨ����Ʒ��id�õ�����
	public String goodsNum(String goodsId){
		
		return hm.get(goodsId).toString();
	}
	
	public String getGoodsNumById(String goodsId){
		
		return (String)hm.get(goodsId);
	}
	
	//�����Ʒ

	public void addGoods(String goodsId,String num){
		
		hm.put(goodsId, num);
	}
	
	
	//ɾ����Ʒ
	
	public void delGoods(String goodsId){
		
		hm.remove(goodsId);
	}
	//��չ��ﳵ
	public void clearMyCart(){
		
		hm.clear();
	}
	
	//�޸���Ʒ
	public void updGoods(String goodsId,String newNum){
		//Ϊ�˳�����ȶ����������ж��鼮�Ƿ����
		if(hm.containsKey(goodsId)){
			hm.put(goodsId, newNum);
		}
	}
	
	
	//�����ܼ۵ĺ���
	
	public float getAllPrice(){
		

		
		try {
			
			
			//��allprice
			this.allPrice=0.0f;
			ct=new ConnDB().getConn();
			
			String sql="select * from goods where goodsId in(";

			
			//��hm�е�keyֵȡ��
			Iterator it=hm.keySet().iterator();
			
			//����hashmap����û���鼮
			if(it.hasNext()==false){
				
				return 0.0f;
			}
		
			
			while(it.hasNext()){
				
				//ȡ��goodsId
				String goodsId=it.next().toString();
				
				//�ж��ǲ������һ��goodsId
				if(it.hasNext()){
					
					sql+=goodsId+",";
				}else{
					
					sql+=goodsId+")";
				}

			}
			
			
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
			
				//ͨ��bookId,ȡ��hm���������
				String goodsNum=hm.get(rs.getInt(1)+"").toString();
				//�õ�����Ʒ�ĵ���
				float price=rs.getFloat(4);
				
				this.allPrice=this.allPrice+price*Integer.parseInt(goodsNum);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return this.allPrice;
		
	}
	
	//��ʾ��Ʒ�ȵ�
	//�����Ƿ�ҳ//��ѧ������ҵ
	public ArrayList showAllMyCart(){
		
		ArrayList al=new ArrayList();
		
		try {
			
			
			ct=new ConnDB().getConn();
			
			String sql="select * from goods where goodsId in(";
			
			
			
			
			
			//��hm�е�keyֵȡ��
			Iterator it=hm.keySet().iterator();
			
			//����hashmap����û���鼮
			if(it.hasNext()==false){
				
				return al;
			}
		
			
			while(it.hasNext()){
				
				//ȡ��goodsId
				String goodsId=it.next().toString();
				
				//�ж��ǲ������һ��goodsId
				if(it.hasNext()){
					
					sql+=goodsId+",";
				}else{
					
					sql+=goodsId+")";
				}

			}
			
			System.out.println("���sql���Ĺ����ǲ�ѯ�û����й������Ʒ=="+sql);
			
			ps=ct.prepareStatement(sql);
			
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
				gb.setPublisher(rs.getString(8));
				
				al.add(gb);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return al;
	}
	
	public void close(){
		
		try {
			if(rs!=null){
				
				rs.close();
				
			}
			if(ps!=null){
				
				ps.close();
			}
			if(ct!=null){
				
				ct.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
