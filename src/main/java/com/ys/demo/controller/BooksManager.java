package com.ys.demo.controller;

import com.ys.demo.commons.Results;
import com.ys.demo.po.Books;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yangshe on 2016/9/19.
 */
@Controller
@RequestMapping("books/")
public class BooksManager {
    @RequestMapping("addbook")
    @ResponseBody
    public Results addBook(@RequestBody Books books){

        return null;
    }
}
