package com.iweb.dao;


import com.iweb.pojo.ProductImage;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Caesar
 * @date 2022 08 2022/8/15 13:55
 * @description 类的描述与介绍
 */
public class ProductImageDAO {

    public void add(ProductImage img) {
        String sql="insert into img(url,pid) value(?,?)";
        try(Connection c= DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)
        ){
            ps.setString(1,img.getUrl());
            ps.setInt(2,img.getP().getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        String sql="delete from img where id=?";
        try(Connection c= DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)
        ){
            ps.setInt(1,id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<ProductImage> select(int pid) {
        String sql="select * from img where pid=?";
        List<ProductImage> imgs=new ArrayList<>();
        try(Connection c= DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)
        ){
            ps.setInt(1,pid);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                ProductImage img=new ProductImage();
                img.setId(rs.getInt("id"));
                img.setUrl(rs.getString("url"));
                imgs.add(img);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return imgs;
    }
}
