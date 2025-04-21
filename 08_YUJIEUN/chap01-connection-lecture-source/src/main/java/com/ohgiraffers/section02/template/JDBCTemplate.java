package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            String url = props.getProperty("url");
            con = DriverManager.getConnection(url,props);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return con;
        }

    public static void close(Connection con) {


        try{
            con = JDBCTemplate.getConnection();
            System.out.println("con"+con);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
