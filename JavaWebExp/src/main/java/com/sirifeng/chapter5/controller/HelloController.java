package com.sirifeng.chapter5.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sirifeng.chapter5.entity.Book;
import com.sirifeng.chapter5.mapper.BooksMapper;
import com.sirifeng.chapter5.services.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SiriFeng
 */
@Controller
public class HelloController {

    @Resource
    private BooksMapper booksMapper;

    @Resource
    private BooksService booksService;

/*    @GetMapping("/hello")
    public ModelAndView showHello() {
        ModelAndView mav = new ModelAndView("hello.jsp");
        Book book = booksMapper.findById("001");
        mav.addObject("book",book);
        return mav;
    }*/

    @GetMapping("/init")
    @ResponseBody
    public String initBooks() {
        booksService.initBooks();
        return "success";
    }

    @GetMapping("/mp")
    @ResponseBody
    public String testMybatisPlus() {
        List<Book> list = booksMapper.selectList(new QueryWrapper<Book>());
        for (Book book : list) {
            System.out.println(book.getIsbn());
        }
        return "SUCCESS";

    }

    @GetMapping("/qw")
    @ResponseBody
    public String testQueryWrapper() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isbn", 001);
        List<Book> list = booksMapper.selectList(queryWrapper);
        for (Book book : list) {
            System.out.println(book.getTitle());
        }
        return "SUCCESS";

    }



}
