package com.demo.dao.impl;

import com.demo.GetSqlSession;
import com.demo.entity.Book;
import com.demo.dao.BookDao;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {



    @Override
    public int addBook(Book book) throws SQLException {
        //获取sqlSession
        SqlSession Session = GetSqlSession.getSqlSession();

        return Session.insert("books.addBook",book);
    }

    @Override
    public int deleteBook(String isbn) throws SQLException {
        //获取sqlSession
        SqlSession session = GetSqlSession.getSqlSession();

            return session.delete("books.deleteBook", isbn);

    }

    @Override
    public Book findBook(String isbn) throws SQLException {
        //获取sqlSession
        SqlSession session = GetSqlSession.getSqlSession();

        return session.selectOne("books.findByIsbn", isbn);

    }

    @Override
    public int updateBook(String isbn) throws SQLException {
        //获取sqlSession
        SqlSession session = GetSqlSession.getSqlSession();

            return session.update("books.updateBook", isbn);

    }

    @Override
    public List<Book> findAll() {

        SqlSession session = GetSqlSession.getSqlSession();

        return session.selectList("books.findAll");
    }
}
