package com.ys.demo.service;

import com.ys.demo.po.Books;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by yangshe on 2016/9/20.
 */
public interface BooksService {
    public int InsertBook(Books books);

}
