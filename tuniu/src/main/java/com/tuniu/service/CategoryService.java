package com.tuniu.service;

import com.tuniu.dao.CategoryDao;
import com.tuniu.domain.Category;
import com.tuniu.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryService {
    public List<Category> findAll() {
        SqlSession sqlsession = MySessionUtils.getSession();
        CategoryDao mapper = sqlsession.getMapper(CategoryDao.class);
        List<Category> result = mapper.findAll();

        return result;
    }
}
