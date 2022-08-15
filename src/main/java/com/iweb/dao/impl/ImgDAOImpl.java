package com.iweb.dao.impl;

import com.iweb.dao.ImgDAO;
import com.iweb.pojo.Img;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GUAN
 * @date 2022/8/15 14:00
 * @description 类的描述和介绍
 */
public class ImgDAOImpl implements ImgDAO {
    @Override
    public void add(Img img) {
        String sql = "insert into img(url) values(?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, img.getUrl());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from img where id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Img> select(int pid) {
        String sql = "select * from img where pid = ?";
        List<Img> imgs = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Img img = new Img();
                img.setId(rs.getInt("id"));
                img.setUrl(rs.getString("url"));
                imgs.add(img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imgs;
    }
}
