

package com.iweb.dao;


import com.iweb.pojo.Order;
import com.iweb.pojo.OrderItem;
import com.iweb.pojo.Product;
import com.iweb.pojo.User;
import com.iweb.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO {
 
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select count(*) from orderItem";
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return total;
    }
 
    public void add(OrderItem bean) {
        String sql = "insert into orderItem values(null,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, bean.getProduct().getId());
            //订单项在创建的时候，是没有蒂订单信息的
            if(null==bean.getOrder()) {
                ps.setInt(2, -1);
            }
            else {
                ps.setInt(2, bean.getOrder().getId());
            }
            
            ps.setInt(3, bean.getUser().getId());
            ps.setInt(4, bean.getNumber());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public void update(OrderItem bean) {
        String sql = "update orderItem set pid= ?, oid=?, uid=?,number=?  where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getProduct().getId());
            if(null==bean.getOrder()) {
                ps.setInt(2, -1);
            }
            else {
                ps.setInt(2, bean.getOrder().getId());
                ps.setInt(3, bean.getUser().getId());
                ps.setInt(4, bean.getNumber());
                ps.setInt(5, bean.getId());
                ps.execute();
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
    public void delete(int id) {
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "delete from orderItem where id = " + id;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
    public OrderItem get(int id) {
        OrderItem bean = new OrderItem();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from orderItem where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                int pid = rs.getInt("pid");
                int oid = rs.getInt("oid");
                int uid = rs.getInt("uid");
                int number = rs.getInt("number");
                Product product = new ProductDAO().get(pid);
                User user = new UserDAO().get(uid);
                bean.setProduct(product);
                bean.setUser(user);
                bean.setNumber(number);
                if(-1!=oid){
                    Order order= new OrderDAO().get(oid);
                    bean.setOrder(order);               	
                }
                bean.setId(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
    }
    //根据用户获取所有属于该用户的订单项(还没有生成订单的订单项)
    public List<OrderItem> listByUser(int uid) {
        return listByUser(uid, 0, Short.MAX_VALUE);
    }
    public List<OrderItem> listByUser(int uid, int start, int count) {
        List<OrderItem> beans = new ArrayList<OrderItem>();
        String sql = "select * from orderItem where uid = ? and oid=-1 order by id desc limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, uid);
            ps.setInt(2, start);
            ps.setInt(3, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderItem bean = new OrderItem();
                int id = rs.getInt(1);
                int pid = rs.getInt("pid");
                int oid = rs.getInt("oid");
                int number = rs.getInt("number");
                Product product = new ProductDAO().get(pid);
                if(-1!=oid){
                    Order order= new OrderDAO().get(oid);
                    bean.setOrder(order);               	
                }
                User user = new UserDAO().get(uid);
                bean.setProduct(product);
                bean.setUser(user);
                bean.setNumber(number);
                bean.setId(id);                
                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return beans;
    }
    //查询某个订单下的所有订单项
    public List<OrderItem> listByOrder(int oid) {
    	return listByOrder(oid, 0, Short.MAX_VALUE);
    }
    public List<OrderItem> listByOrder(int oid, int start, int count) {
    	List<OrderItem> beans = new ArrayList<OrderItem>();
    	String sql = "select * from orderItem where oid = ? order by id desc limit ?,? ";
    	try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
    		ps.setInt(1, oid);
    		ps.setInt(2, start);
    		ps.setInt(3, count);
    		ResultSet rs = ps.executeQuery();
    		while (rs.next()) {
    			OrderItem bean = new OrderItem();
    			int id = rs.getInt(1);
    			int pid = rs.getInt("pid");
    			int uid = rs.getInt("uid");
    			int number = rs.getInt("number");
    			Product product = new ProductDAO().get(pid);
    			if(-1!=oid){
    				Order order= new OrderDAO().get(oid);
    				bean.setOrder(order);               	
    			}
    			User user = new UserDAO().get(uid);
    			bean.setProduct(product);
    			bean.setUser(user);
    			bean.setNumber(number);
    			bean.setId(id);                
    			beans.add(bean);
    		}
    	} catch (SQLException e) {
    		
    		e.printStackTrace();
    	}
    	return beans;
    }
    //遍历一个订单集合 把集合中所有的订单和它对应的的订单项进行绑定
    public void fill(List<Order> os) {
		for (Order o : os) {
			List<OrderItem> ois=listByOrder(o.getId());
			float total = 0;
			int totalNumber = 0;
			for (OrderItem oi : ois) {
				 total+=oi.getNumber()*oi.getProduct().getPromotePrice();
				 totalNumber+=oi.getNumber();
			}
			o.setTotal(total);
			o.setOrderItems(ois);
			o.setTotalNumber(totalNumber);
		}
	}
    //为订单设置订单项集合 (把订单和它的订单项对象进行属性绑定)
	public void fill(Order o) {
		List<OrderItem> ois=listByOrder(o.getId());
		float total = 0;
		for (OrderItem oi : ois) {
			 total+=oi.getNumber()*oi.getProduct().getPromotePrice();
		}
		o.setTotal(total);
		//把订单对象和该订单对应的订单项集合进行关联
		o.setOrderItems(ois);
	}
    public List<OrderItem> listByProduct(int pid) {
        return listByProduct(pid, 0, Short.MAX_VALUE);
    }
    public List<OrderItem> listByProduct(int pid, int start, int count) {
        List<OrderItem> beans = new ArrayList<OrderItem>();
        String sql = "select * from orderItem where pid = ? order by id desc limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, pid);
            ps.setInt(2, start);
            ps.setInt(3, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderItem bean = new OrderItem();
                int id = rs.getInt(1);
                int uid = rs.getInt("uid");
                int oid = rs.getInt("oid");
                int number = rs.getInt("number");
                Product product = new ProductDAO().get(pid);
                if(-1!=oid){
                    Order order= new OrderDAO().get(oid);
                    bean.setOrder(order);               	
                }
                User user = new UserDAO().get(uid);
                bean.setProduct(product);
                bean.setUser(user);
                bean.setNumber(number);
                bean.setId(id);                
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }
     //获取某一个产品的销量
	public int getSaleCount(int pid) {
		 int total = 0;
	        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	            String sql = "select sum(number) from orderItem where pid = " + pid;
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                total = rs.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return total;
	}
}

