package service;

import domain.User;
import domain.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<User> users = new ArrayList<>();
    private final List<Menu> menus = new ArrayList<>();

    // 유저 생성
    public void createUser(String email, String password, String name) {
        if (users.stream().anyMatch(user -> user.email().equals(email))) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

        User newUser = User.createUser(email, password, name);
        users.add(newUser);
    }

    public boolean isEmailExist(String email) {
        return users.stream().anyMatch(user -> user.email().equals(email));
    }

    // 유저 삭제
    public void removeUser(String email, String password) {
        users.removeIf(user -> user.email().equals(email) && user.password().equals(password));
    }

    // 유저 목록 조회
    public List<User> listAllUsers() {
        return users;
    }

//    // 유저 메뉴 추가
//    public void addMenuToUser(String userEmail, Integer menuNumber) {
//        Optional<Menu> menu = menus.stream().filter(m -> m.menuNumber().equals(menuNumber)).findFirst();
//
//        users.stream()
//                .filter(user -> user.email().equals(userEmail))
//                .findFirst()
//                .ifPresent(user -> {
//                    if (menu.isPresent()) {
//                        List<Menu> updatedMenuList = new ArrayList<>(user.menuList());
//                        updatedMenuList.add(menu.get());
//                        updateUser(user, updatedMenuList);
//                    } else {
//                        throw new IllegalStateException("메뉴를 찾을 수 없습니다.");
//                    }
//                });
//    }
//
//    // 유저 메뉴 삭제
//    public void removeMenuFromUser(String userEmail, Integer menuNumber) {
//        users.stream()
//                .filter(user -> user.email().equals(userEmail))
//                .findFirst()
//                .ifPresent(user -> {
//                    List<Menu> updatedMenuList = new ArrayList<>(user.menuList());
//                    updatedMenuList.removeIf(menu -> menu.menuNumber().equals(menuNumber));
//                    updateUser(user, updatedMenuList);
//                });
//    }
//
//    // 유저 시간 추가
//    public void addTimeToUser(String userEmail, Integer chargingTime) {
//        if (chargingTime % 1 != 0) {
//            throw new IllegalArgumentException("시간은 1시간 단위로만 추가할 수 있습니다.");
//        }
//
//        users.stream()
//                .filter(user -> user.email().equals(userEmail))
//                .findFirst()
//                .ifPresent(user -> {
//                    int newTotalTime = user.chargingTime() + chargingTime;
//                    int newTotalPrice = user.totalPrice() + (chargingTime / 60) * 1000;
//                    updateUser(user, newTotalTime, newTotalPrice);
//                });
//    }
//
//    // 유저 정보 업데이트 (메뉴 리스트 업데이트)
//    private void updateUser(User user, List<Menu> updatedMenuList) {
//        User updatedUser = new User(
//                user.email(), user.password(), user.name(), user.regDate(),
//                updatedMenuList, user.chargingTime(), user.totalPrice()
//        );
//        users.set(users.indexOf(user), updatedUser);
//    }
//
//    // 유저 정보 업데이트 (시간 및 총 금액 업데이트)
//    private void updateUser(User user, int newChargingTime, int newTotalPrice) {
//        User updatedUser = new User(
//                user.email(), user.password(), user.name(), user.regDate(),
//                user.menuList(), newChargingTime, newTotalPrice
//        );
//        users.set(users.indexOf(user), updatedUser);
//    }

    // 기타 필요한 메소드...
}
