package com.iweb;

import com.iweb.pojo.User;

/**
 * @author GUAN
 * @date 2022/8/13 9:10
 */
public interface UserDAO {
    /** 用来验证用户登录
     * @param user 包含用户名和密码的登录信息
     * @return 返回的布尔值代表验证的情况
     */
    boolean login(User user);
}
