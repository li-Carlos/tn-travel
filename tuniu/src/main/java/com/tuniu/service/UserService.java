package com.tuniu.service;


import com.tuniu.dao.UserDao;
import com.tuniu.domain.User;
import com.tuniu.util.MySessionUtils;

public class UserService {
    //直接获取Dao

    public User findUserByName(String name) {
        //getMapper是mybatis,给接口生成实现类，将实现类对象返回
        UserDao userDao = MySessionUtils.getSession().getMapper(UserDao.class);
        //根据用户名查找用户
        User user = userDao.findByName(name);
       MySessionUtils.getSession().commit();
        return user;
    }

    public int login(User user) {
        //账号密码
        UserDao userDao = MySessionUtils.getSession().getMapper(UserDao.class);
        User u = userDao.findByName(user.getUsername());
        //比对数据库的账号密码
        if (u == null) {
            return -1;//找不到jack
        } else {
            //判断是否是激活的账户
            if ("Y".equals(u.getStatus())) {
                //是激活用户
                if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                    return 1;//提示登录成功
                } else {
                    return -2;//账号或者密码出错
                }
            } else {
                return -3;//已激活
            }
        }
    }
}
