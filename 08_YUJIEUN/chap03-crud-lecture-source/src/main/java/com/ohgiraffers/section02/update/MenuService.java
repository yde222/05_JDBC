package com.ohgiraffers.section02.update;

/*
 * Service 계층: 비즈니스 로직을 구현하는 계층
 * 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
 * */

import java.sql.Connection;

import static com.ohgiraggers.common.JDBCTemplate.*;

public class MenuService {

     private MenuRepository menuRepositoy = new MenuRepository();

     public void registMenu(Menu modifymenu) {
          System.out.println("[MenuService]regisMenu: menu ===> "+modifymenu);

          Connection con = getConnection();
          int result = menuRepositoy.updateMenu(con,modifymenu);

          if (result > 0) {
               commit(con);
          }else {
               rollback(con);
          }
          close(con);
          System.out.println("[MenuService]regisMenu: End ===>");
     }

}
