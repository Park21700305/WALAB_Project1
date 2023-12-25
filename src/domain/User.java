package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record User(
        String email,
        String password,
        String name,
        LocalDateTime regDate,
        List<MenuOrder> menuOrders,
        Integer chargingTime,
        Integer totalPrice
) {
    // 정적 팩토리 메소드
    public static User createUser(String email, String password, String name) {
        return new User(
                email,
                password,
                name,
                LocalDateTime.now(),
                new ArrayList<MenuOrder>(),
                0, // 사용 시간 초기값
                0  // 가격 초기값
        );
    }
}
