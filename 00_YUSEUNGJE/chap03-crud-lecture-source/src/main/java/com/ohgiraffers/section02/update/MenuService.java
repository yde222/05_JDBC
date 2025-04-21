package com.ohgiraffers.section02.update;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/*
* Service계층 : 비즈니스 로직을 구현하는 계층
* 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
* */
public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public void modifyMenu(Menu modifyMenu) {
        System.out.println("[MenuService]modifyMenu:  menu ===> " + modifyMenu);

        Connection con = getConnection();
        int result = menuRepository.updateMenu(con, modifyMenu);

        // 수행 결과에 따라서 Commit, Rollback 정해야한다.
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        System.out.println("[MenuService]modifyMenu:  End ===> ");
    }
}
