package com.ohgiraffers.section01.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {

    public static void main(String[] args) {
        Properties props = new Properties();

        Connection con = null;

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            /* 설정 정보는 유지 보수성을 위해 리터럴 값으로 작성하지 않고 별도의 파일로 분리한다. */
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306","ohgiraffers","ohgiraffers");
            con = DriverManager.getConnection(url,props);

            System.out.println("con = " + con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
