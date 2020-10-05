package com.tuniu.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuniu.domain.Category;
import com.tuniu.domain.ResponseInfo;
import com.tuniu.service.CategoryService;
import com.tuniu.util.JedisUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost....run");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet....run");
        Jedis jedis = JedisUtil.getJedis();
        String json = jedis.get("category_list");
        if (json != null) {
            System.out.println(json);
            response.getWriter().println(json);
        } else {
            CategoryService categoryService = new CategoryService();
            List<Category> result = categoryService.findAll();
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setCode(200);
            responseInfo.setData(result);
            json = new ObjectMapper().writeValueAsString(responseInfo);
            response.getWriter().println(json);
        }

    }
}
