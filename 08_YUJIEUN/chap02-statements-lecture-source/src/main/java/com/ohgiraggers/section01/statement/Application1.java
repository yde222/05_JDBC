package com.ohgiraggers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraggers.common.JDBCTemplate.close;
import static com.ohgiraggers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {

        /* 트랜잭션 처리를 위한 DBMS연*/
        Connection con = getConnection();
        System.out.println("con="+con);

        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECLT * FROM tbl_menu");

            /*while문 안의 rset은 한 행을 의미*/
            while(rset.next()){
                System.out.println(rset.getString("menu_name"+ " "));
                System.out.println(rset.getString("menu_price"+"\n"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rSet);
            close(stmt);
            close(con);
        }



    }
}
