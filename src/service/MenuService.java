package service;

import domain.Menu;
import domain.MenuOrder;
import domain.User;

import java.util.Arrays;
import java.util.List;

public class MenuService {
    private final List<Menu> menus = Arrays.asList(Menu.values());

    public void addMenuOrderToUser(User user, Menu menu, int quantity) {
        MenuOrder menuOrder = new MenuOrder(menu, quantity);
        user.getMenuOrders().add(menuOrder);

        // 가격과 시간을 업데이트
        int totalPrice = user.getTotalPrice() + menu.getPrice() * quantity;
        user.setTotalPrice(totalPrice);

        // 메뉴가 시간 관련 메뉴인 경우 시간을 추가
        if (menu.name().startsWith("TIME")) {
            int additionalTime = Integer.parseInt(menu.getMenuName().split(" ")[0]) * quantity;
            int newChargingTime = user.getChargingTime() + additionalTime;
            user.setChargingTime(newChargingTime);
        }
    }

    // 기존 메소드들...
}
