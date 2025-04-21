package com.ohgiraffers.section03.delete;

/*
 * Service 계층: 비즈니스 로직을 구현하는 계층
 * 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
 * */

import com.ohgiraffers.section03.delete.Menu;
import com.ohgiraffers.section03.delete.MenuRepository;

import java.sql.Connection;

import static com.ohgiraggers.common.JDBCTemplate.*;

public class MenuService {

     private MenuRepository menuRepositoy = new MenuRepository();

     public void delteMenu(Menu delteMenu) {
          System.out.println("[MenuService]regisMenu: menu ===> "+delteMenu);

          Connection con = getConnection();
          int result = menuRepositoy.delteMenu(con,delteMenu);

          if (result > 0) {
               commit(con);
          }else {
               rollback(con);
          }
          close(con);
          System.out.println("[MenuService]regisMenu: End ===>");
     }

}
