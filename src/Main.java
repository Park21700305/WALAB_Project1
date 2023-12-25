import view.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserView userView = new UserView();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1: 회원가입, 2: 회원목록조회, 3: 회원탈퇴, 0: 종료");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userView.createUser();
                    break;
                case 2:
                    userView.ListAllUsers();
                    break;
                case 3:
                    userView.removeUser();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
