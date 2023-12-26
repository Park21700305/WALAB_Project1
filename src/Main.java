 /*
    프로그램 시작 시 "1. 회원가입 2. 로그인 3. 회원삭제 4. 회원목록 5. 메뉴보기 6. 시스템 종료" 메뉴를 보여준다.
      로그인 시 "1.메뉴선택 2.내정보수정 3.로그아웃 4.주문내역보기 5.주문삭제" 메뉴를 보여준다.
      메뉴선택 시 "1.떡볶이 2.라면 3.콜라 4.소떡소떡 5.1시간 추가 6.2시간 추가 7.3시간 추가" 메뉴를 보여준다.
      주문내역보기 시 "지금까지 내가 주문한 내역을 모두 보여준다.
      주문삭제 시 "주문한 내역 중 삭제하고 싶은 메뉴를 선택하면 삭제한다.
      내정보수정 시 "1.이메일 2.비밀번호 3.이름" 중 수정하고 싶은 정보를 선택하면 수정한다.
      회원삭제 시 "이메일과 비밀번호를 입력하면 회원정보를 삭제한다.
      회원목록 시 "현재 가입한 회원들의 아이디와 이름 목록을 보여준다.
      시스템 종료 시 "프로그램을 종료한다.

     */
 import domain.User;
 import service.MenuService;
 import service.UserService;
 import view.MenuView;
 import view.UserView;

 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         UserService userService = new UserService();
         MenuService menuService = new MenuService();
         UserView userView = new UserView(userService, scanner);
         MenuView menuView = new MenuView(menuService, scanner);

         User loggedInUser = null; // 로그인된 사용자 추적

         while (true) {
             if (loggedInUser == null) {
                 System.out.println("1.회원가입 2.로그인 3.회원삭제 4.회원목록 5.메뉴보기 6.시스템종료");
                 int choice = scanner.nextInt();
                 scanner.nextLine();

                 switch (choice) {
                     case 1:
                         userView.createUser();
                         break;
                     case 2:
                         loggedInUser = userView.login();
                         break;
                     case 3:
                         userView.removeUser();
                         break;
                     case 4:
                         userView.listAllUsers();
                         break;
                     case 5:
                         menuView.showMenus();
                         break;
                     case 6:
                         System.out.println("시스템을 종료합니다.");
                         return;
                     default:
                         System.out.println("잘못된 입력입니다.");
                 }
             } else {
                 System.out.println("1.메뉴선택 2.내정보수정 3.로그아웃 4.주문내역보기 5.주문삭제");
                 int choice = scanner.nextInt();
                 scanner.nextLine();

                 switch (choice) {
                     case 1:
                         menuView.addOrderToUser(loggedInUser);
                         break;
                     case 2:
                         userView.updateUserInfo(loggedInUser);
                         break;
                     case 3:
                         loggedInUser = null;
                         System.out.println("---로그아웃 되었습니다.---");
                         break;
                     case 4:
                         userView.viewUserDetails(loggedInUser.getEmail());
                         break;
                     case 5:
                         userView.removeOrder(loggedInUser);
                         break;
                 }
             }
         }
     }
 }
