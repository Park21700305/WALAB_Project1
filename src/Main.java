import view.MenuView;
import view.UserView;
import service.MenuService;
import service.UserService;
import domain.User;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        MenuService menuService = new MenuService();

        UserView userView = new UserView(userService);
        MenuView menuView = new MenuView(menuService);

        User user = userView.login();

        while (true) {
            menuView.showMenus();
            menuView.addOrderToUser(user);
            userView.showUserInfo(user);
        }
    }
}
