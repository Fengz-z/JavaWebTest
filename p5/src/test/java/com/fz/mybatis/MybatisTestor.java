package com.fz.mybatis;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class MybatisTestor {


    @Test
    public void testFind() throws IOException, SQLException, NamingException {
        System.out.println("here");
        Context context = new InitialContext();
        Context envContext = (Context)InitialContext.doLookup("java:comp/env");
        DataSource dataSource = (DataSource)envContext.lookup("jdbc/webstoreDS");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        }




    public static void main(String[] args) throws IOException, SQLException, NamingException {
        MybatisTestor mybatisTestor = new MybatisTestor();
        mybatisTestor.testFind();
    }
}
