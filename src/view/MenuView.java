package view;

import domain.Menu;
import domain.User;
import service.MenuService;
import service.UserService;

import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);
    private final MenuService menuService;

    public MenuView(MenuService menuService) {
        this.menuService = menuService;
    }

    public void showMenus() {
        System.out.println("메뉴 목록:");
        for (Menu menu : Menu.values()) {
            System.out.println(menu.name() + ": " + menu.getMenuName() + " - 가격: " + menu.getPrice() + "원");
        }
    }

    public void addOrderToUser(User user) {
        showMenus();
        System.out.print("메뉴 선택 (예: MENU1 2): ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        Menu selectedMenu = Menu.valueOf(parts[0]);
        int quantity = Integer.parseInt(parts[1]);

        menuService.addMenuOrderToUser(user, selectedMenu, quantity);
        System.out.println("메뉴가 추가되었습니다.");
    }

    // 기존 메소드들...
}
