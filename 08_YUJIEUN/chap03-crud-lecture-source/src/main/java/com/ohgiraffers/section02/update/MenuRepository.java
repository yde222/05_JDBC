package com.ohgiraffers.section02.update;



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

    public int updateMenu(Connection con, Menu modifyMenu) {

        System.out.println("[MenuService]updateMenu: menu ===>" + modifyMenu);
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String query = prop.getProperty("updateMenu");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt(2, modifyMenu.getMenuPrice());
            pstmt.setInt(3, modifyMenu.getCategoryCode());
            pstmt.setString(4, modifyMenu.getOrderableStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("메뉴 등록 중 오류 발생", e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[MenuService]updateMenu: result ===>" + result);
        return result;
    }



}

