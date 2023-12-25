package view;

import domain.User;
import service.UserService;

import java.util.Scanner;
import java.util.stream.Collectors;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();

    public void createUser() {

        System.out.println("-----------회원가입-----------");

        String email;

        while (true) {
            System.out.print("이메일: ");
            email = scanner.nextLine();
            if (userService.isEmailExist(email)) {
                System.out.println("이미 존재하는 이메일입니다. 다른 이메일을 입력해주세요.");
            } else {
                break;
            }
        }
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();

        userService.createUser(email, password, name);
        System.out.println("유저가 생성되었습니다.");
        System.out.println("--------------------------");
    }

    // 유저 삭제를 위한 메소드
    public void removeUser() {

        System.out.println("-----------회원삭제-----------");
        String email;

        while (true) {
            System.out.print("이메일: ");
            email = scanner.nextLine();
            if (!userService.isEmailExist(email)) {
                System.out.println("존재하지 않는 이메일입니다. 다른 이메일을 입력해주세요.");
            } else {
                break;
            }
        }

        System.out.print("비밀번호(입력 시 정보가 삭제됩니다.): ");
        String password = scanner.nextLine();

        userService.removeUser(email, password);
        System.out.println("유저가 삭제되었습니다.");
        System.out.println("--------------------------");
    }

    public void ListAllUsers() {
        System.out.println("-----------회원목록-----------");
        for (User user : userService.listAllUsers()) {
            String menuListString = user.menuList().stream()
                    .map(menu -> menu.menuName())
                    .collect(Collectors.joining(", "));

            System.out.println("이름: " + user.name() +
                    ", 이메일: " + user.email() +
                    ", 비밀번호: " + user.password() +
                    ", 가입날짜: " + user.regDate() +
                    ", 주문메뉴: " + menuListString +
                    ", 충전시간: " + user.chargingTime() + "시간" +
                    ", 지불금액: " + user.totalPrice() + "원");
        }
        System.out.println("--------------------------");
    }



}
