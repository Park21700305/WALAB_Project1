package domain;

public enum Menu {
    MENU1("떡볶이", 3000),
    MENU2("라면", 2500),
    MENU3("콜라", 1000),
    MENU4("소떡소떡", 2000);

    private final String menuName;
    private final Integer price;

    Menu(String menuName, Integer price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public Integer getPrice() {
        return price;
    }
}
