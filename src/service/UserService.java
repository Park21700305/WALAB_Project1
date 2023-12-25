package service;

import domain.User;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserService {
    private final List<User> users = new ArrayList<>();

    // 유저 생성
    public void createUser(String email, String password, String name) {
        if (isEmailExist(email)) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

        // User 객체를 빌더 패턴을 사용하여 생성
        User newUser = User.builder()
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
        return new ArrayList<>(users); // 혹은 Collections.unmodifiableList(users); 사용
    }

}
