package service;

import domain.Menu;
import domain.MenuOrder;
import domain.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuService {
    private final List<Menu> menus = Arrays.asList(Menu.values());

    public MenuService() {
        // 메뉴 서비스 초기화 (필요한 경우)
    }

    public void addMenuOrderToUser(User user, Menu menu, int quantity) {
        MenuOrder menuOrder = new MenuOrder(menu, quantity);
        user.getMenuOrders().add(menuOrder);

        // 가격과 시간을 업데이트
        int totalPrice = user.getTotalPrice() + menu.getPrice() * quantity;
        user.setTotalPrice(totalPrice);

        // 메뉴가 시간 관련 메뉴인 경우 시간을 추가
        if (menu.name().startsWith("TIME")) {
            String timeString = menu.getMenuName();

            int additionalTime = Integer.parseInt(timeString.replaceAll("[^0-9]", "")) * quantity;
            int newChargingTime = user.getChargingTime() + additionalTime;
            user.setChargingTime(newChargingTime);
        }

    }

    public List<Menu> getMenus() {
        return new ArrayList<>(menus); // 메뉴 목록 반환
    }
}
