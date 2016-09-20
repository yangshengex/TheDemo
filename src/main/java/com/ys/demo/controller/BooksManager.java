package com.ys.demo.controller;

import com.ys.demo.commons.CreateToken;
import com.ys.demo.commons.Untils;
import com.ys.demo.po.Books;
import com.ys.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by yangshe on 2016/9/19.
 */
@Controller
@RequestMapping("books/")
public class BooksManager {
    @Autowired
    private BooksService booksService;
    @RequestMapping("addbook")
    public String addBookUI(Books books, MultipartFile book_cover, HttpServletRequest request) throws Exception {

        if(book_cover!=null){
            System.out.println("cover中是有值的");
            //原始文件名称
            String pictureFile_name =  book_cover.getOriginalFilename();
            //新文件名称
            String newFileName = UUID.randomUUID().toString()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

            //上传图片C:/MyFile/uploadFile表示的是和uploadFile在同一目录下C:/MyFile/uploadFile/表示是uploadFile目录下
            File uploadPic = new File("./src/main/webapp/resources/uploadImg/"+newFileName);
            if(!uploadPic.exists()){
                uploadPic.mkdirs();
//			uploadPic.mkdir();
            }
            //向磁盘写文件
            book_cover.transferTo(uploadPic);
            //需要把文件名存入Books对象中
            books.setCover(newFileName);
            //设置添加的时间
            books.setAdd_time(Untils.getNowTime());
            System.out.println("收到的图书信息："+books);
            int uprow = booksService.InsertBook(books);
            if(uprow>0) {
                request.getSession().setAttribute("messages", "添加图书成功");
                System.out.println("已经运行到保存文件的代码成功的结果!!!!**************************8" + newFileName);
            }else {
                request.getSession().setAttribute("messages", "未知原因添加图书失败");
            }
            }

        //重置token
        request.getSession().setAttribute("token", CreateToken.getCreateToken().makeToken());
        return "LoginedUI";
    }
}
