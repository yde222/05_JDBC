package com.ohgiraggers.common;

import javax.sql.RowSet;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/config/jdbc-config.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            Class.forName(driver);

            con = DriverManager.getConnection(url,props);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return con;
        }

    public static void close(Connection con) {

      if (con != null) {
          try {
              con.close();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
    }
}
