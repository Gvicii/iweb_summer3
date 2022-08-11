package com.iweb.dao;

import com.iweb.pojo.Category;

import java.util.List;

/** 分类的DAO接口
 * @author GUAN
 * @date 2022/8/11 15:42
 */
public interface CategoryDAO {

    /**增
     * @param category 要添加的分类对象引用
     */
    void add(Category category);

    /** 根据id删除分类
     * @param id 分类id
     */
    void delete(int id);

    /** 修改分类数据
     * @param category
     */
    void update(Category category);

    /** 根据id获取单个分类对象
     * @param id 参数id 对应分类主键
     * @return 根据id得到的分类对象
     */
    Category get(int id);

    /** 用来对分类信息进行分页查询
     * @param start 查询语句起始截止行数
     * @param count 截取行数
     * @return
     */
    List<Category> listByLimit(int start,int count);

    /** 默认查询所有分类
     * @return 查询到的所有分类集合
     */
    List<Category> list();

}
