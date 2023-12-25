package domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String email;
    private String password;
    private String name;
    private LocalDateTime regDate = LocalDateTime.now();
    private List<MenuOrder> menuOrders = new ArrayList<>();
    private Integer chargingTime = 0;
    private Integer totalPrice = 0;
}
