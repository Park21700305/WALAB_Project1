package service;

import domain.User;
import domain.MenuOrder;

import java.util.List;
import java.util.ArrayList;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public void createUser(Long id, String email, String password, String name) {
        if (isEmailExist(email)) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

        User newUser = User.builder()
                .id(id++)
                .email(email)
                .password(password)
                .name(name)
                .build();

        users.add(newUser);
    }

    // 이메일 중복 체크
    public boolean isEmailExist(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    // 유저 삭제
    public void removeUser(String email, String password) {
        users.removeIf(user -> user.getEmail().equals(email) && user.getPassword().equals(password));
    }

    // 유저 목록 조회
    public List<User> listAllUsers() {
        return new ArrayList<>(users);
    }

    // 사용자 찾기
    public User findUser(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    // 사용자 정보 수정
    public void updateUser(User user, String email, String password, String name) {
        if (user != null) {
            if (email != null && !email.isEmpty()) user.setEmail(email);
            if (password != null && !password.isEmpty()) user.setPassword(password);
            if (name != null && !name.isEmpty()) user.setName(name);
        }
    }

    // 주문 내역 삭제
    public void removeOrder(User user, MenuOrder order) {
        if (user != null && order != null) {
            user.getMenuOrders().remove(order);
        }
    }
}
