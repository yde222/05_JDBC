package com.ohgiraffers.section01.insert;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴명 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴 가격 : ");
        int menuPrice = sc.nextInt();
        System.out.println("카테고리 코드 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.println("판매상태 : ");
        String orderableStatus = sc.nextLine();
        /*사용자 화면 끝 부분*/

        /*Controller 시작 부분*/
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        System.out.println("[Application] main() : menu ====> "+menu.toString());

        MenuService menuService = new MenuService();
        menuService.registMenu(menu);

    }
}
