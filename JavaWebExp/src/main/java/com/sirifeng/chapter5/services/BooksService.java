package com.sirifeng.chapter5.services;


import com.sirifeng.chapter5.entity.Book;
import com.sirifeng.chapter5.mapper.BooksMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BooksService {

    @Resource
    private BooksMapper booksMapper;

    @Transactional(rollbackFor = Exception.class)
    public void initBooks() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setIsbn("批量导入测试"+i);
            book.setTitle("test");
            book.setPrice(i);
            booksMapper.insert(book);

        }
    }
}
