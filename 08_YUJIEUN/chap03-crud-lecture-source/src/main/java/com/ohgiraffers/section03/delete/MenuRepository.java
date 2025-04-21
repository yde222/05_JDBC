package com.ohgiraffers.section03.delete;



import com.ohgiraffers.section02.update.Menu;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class MenuRepository {
    private final Properties prop = new Properties();


    public MenuRepository() {
        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));
        } catch (Exception e) {
            throw new RuntimeException("쿼리 파일 로딩 실패", e);
        }
    }




    public int delteMenu(Connection con, int delteCode) {
        PreparedStatement pstmt = null;
        int result = 0;

        String sql =properties.pro;

        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, delteCode.getMenuName());
        pstmt.setInt(2, delteCode.getMenuPrice());
        pstmt.setInt(3, delteCode.getCategoryCode());
        pstmt.setString(4, delteCode.getOrderableStatus());

    }
}

