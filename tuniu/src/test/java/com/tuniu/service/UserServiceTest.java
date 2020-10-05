package com.tuniu.service;

import com.tuniu.dao.UserDao;
import com.tuniu.domain.User;
import com.tuniu.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void test01(){
        //获取连接
        SqlSession sqlSession = MySessionUtils.getSession();
        //1.查找用户数据
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findByName("lbl");
        if (user == null) {
            System.out.println("该用户不存在！");
        }else {
            System.out.println("该用户已存在！");
        }
    }

    @Test
    public void test02(){
        //
        SqlSession sqlsession = MySessionUtils.getSession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        User user = mapper.findlikeName("%l%");
        if (user == null) {
            System.out.println("该用户不存在！");
        }else {
            System.out.println("该用户已存在！");
        }
    }
    @Test
    public void test03(){
        //
        SqlSession sqlsession = MySessionUtils.getSession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        User user = mapper.findlikeName2("l");
        if (user == null) {
            System.out.println("该用户不存在！");
        }else {
            System.out.println("该用户已存在！");
        }
    }
}
