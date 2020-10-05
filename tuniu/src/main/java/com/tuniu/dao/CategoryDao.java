package com.tuniu.dao;

import com.tuniu.domain.Category;

import java.util.List;

public interface CategoryDao {
    //SELECT * FROM `tab_category` ORDER BY cid ASC
    List<Category> findAll();
}
