package com.demo.dao;

import com.demo.entity.Book;

import java.sql.SQLException;
import java.util.List;


public interface BookDao {
    /**
     * 添加图书
     * @param book
     * @return
     * @throws SQLException
     */
    int addBook(Book book) throws SQLException;

    /**
     * 按书号删除图书
     * @param isbn
     * @return
     * @throws SQLException
     */
    int deleteBook(String isbn) throws SQLException;

    /**
     * 按书号查找
     * @param isbn
     * @return
     * @throws SQLException
     */
    Book findBook(String isbn) throws SQLException;

    List<Book> findAll() throws SQLException;

    /**
     * 按书号更新图书信息
     * @param isbn
     * @return
     * @throws SQLException
     */
    int updateBook(String isbn) throws SQLException;
}
