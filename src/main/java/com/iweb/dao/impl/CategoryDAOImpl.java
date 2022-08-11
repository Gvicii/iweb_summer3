package com.iweb.dao.impl;

import com.iweb.dao.CategoryDAO;
import com.iweb.pojo.Category;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GUAN
 * @date 2022/8/11 15:49
 */
public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public void add(Category category) {
        String sql = "insert into category(name) values(?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, category.getName());
            ps.execute();
        } catch (SQLException e) {

        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from category where id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {

        }
    }

    @Override
    public void update(Category category) {
        String sql = "update category set name = ? where id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.execute();
        } catch (SQLException e) {

        }
    }

    @Override
    public Category get(int id) {
        Category category = null;
        String sql = "select * from category where id = ? ";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(id);
                category.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
        }
        return category;
    }

    @Override
    public List<Category> listByLimit(int start, int count) {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from category limit ?,? ";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
        }
        return categories;
    }

    @Override
    public List<Category> list() {
        return listByLimit(0,Integer.MAX_VALUE);
    }
}
