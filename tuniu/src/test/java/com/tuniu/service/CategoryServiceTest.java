package com.tuniu.service;

import com.tuniu.domain.Category;
import org.junit.Test;

import java.util.List;

public class CategoryServiceTest {
    @Test
    public void test01(){
        CategoryService categoryService = new CategoryService();
        List<Category> list= categoryService.findAll();
        System.out.println(list);

    }
}
