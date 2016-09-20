package com.ys.demo.serviceimpl;

import com.ys.demo.mapper.BooksMapper;
import com.ys.demo.po.Books;
import com.ys.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangshe on 2016/9/20.
 */
@Service
public class BookServiceimpl implements BooksService{
    @Autowired
    BooksMapper booksMapper;
    @Override
    public int InsertBook(Books books) {
        return booksMapper.insertBook(books);
    }
}
