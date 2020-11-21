package com.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class GetSqlSession {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = GetSqlSessionFactory.getSqlSessionFactory().openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void commit() {
        if (threadLocal != null) {
            threadLocal.get().commit();
            threadLocal.get().close();
            threadLocal.set(null);
            System.out.println("提交成功");
        }
    }

    public static void rollback() {
        if (threadLocal.get() != null) {
            threadLocal.get().rollback();
            threadLocal.get().close();
            threadLocal.set(null);
            System.out.println("回滚了");
        }
    }

}
