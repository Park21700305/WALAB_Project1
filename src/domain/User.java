package domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private String name;
    private LocalDateTime regDate;
    private List<MenuOrder> menuOrders;
    private Integer chargingTime;
    private Integer totalPrice;

    @Builder
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.regDate = LocalDateTime.now();
        this.menuOrders = new ArrayList<>();
        this.chargingTime = 0;
        this.totalPrice = 0;
    }


}
