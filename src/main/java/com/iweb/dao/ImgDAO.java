package com.iweb.dao;

import com.iweb.pojo.Img;

import java.util.List;

/**
 * @author GUAN
 * @date 2022/8/15 13:55
 * @description 类的描述和介绍
 */
public interface ImgDAO {
    void add(Img img);
    void delete(int id);
    List<Img> select(int pid);
}
