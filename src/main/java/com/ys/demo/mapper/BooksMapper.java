package com.ys.demo.mapper;

import com.ys.demo.po.Books;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yangshe on 2016/9/20.
 */
public interface BooksMapper {
    public int insertBook(Books books);
}
