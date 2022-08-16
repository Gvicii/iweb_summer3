

package com.iweb.dao;

import com.iweb.pojo.Category;
import com.iweb.pojo.Property;
import com.iweb.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
//获取的是某种分类下的属性总数
    // 用于后续分页使用
    public int getTotal(int cid) {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select count(*) from property where cid =" + cid;
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return total;
    }
 
    public void add(Property bean) {




        String sql = "insert into property values(null,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, bean.getCategory().getId());
            ps.setString(2, bean.getName());
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
 
    public void update(Property bean) {

        String sql = "update property set cid= ?, name=? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {


        	
            ps.setInt(1, bean.getCategory().getId());
            ps.setString(2, bean.getName());
            ps.setInt(3, bean.getId());
            ps.execute();
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
 
    }
 
    public void delete(int id) {
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "delete from property where id = " + id;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public Property get(String name, int cid) {
    	Property bean =null;
		 
		String sql = "select * from property where name = ? and cid = ?";
		
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setString(1, name);
        	ps.setInt(2, cid);
            
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                int id = rs.getInt("id");
                bean = new Property();
                bean.setName(name);
                Category category = new CategoryDAO().get(cid);
                bean.setCategory(category);
                bean.setId(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
	}
    public Property get(int id) {
        Property bean = new Property();
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from property where id = " + id;
 
            ResultSet rs = s.executeQuery(sql);
 
            if (rs.next()) {

                String name = rs.getString("name");
                int cid = rs.getInt("cid");
                bean.setName(name);
                Category category = new CategoryDAO().get(cid);
                bean.setCategory(category);
                bean.setId(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
    }
    //查询某个分类下的属性对象集合
    public List<Property> list(int cid) {
        return list(cid, 0, Short.MAX_VALUE);
    }
 
    public List<Property> list(int cid, int start, int count) {
        List<Property> beans = new ArrayList<Property>();
 
        String sql = "select * from property where cid = ? order by id desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, cid);
            ps.setInt(2, start);
            ps.setInt(3, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Property bean = new Property();
                int id = rs.getInt(1);
                String name = rs.getString("name");
                bean.setName(name);
                Category category = new CategoryDAO().get(cid);
                bean.setCategory(category);
                bean.setId(id);
                
                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
//
        return beans;
    }
 
}

