package domain;

// 메뉴 객체: 메뉴 번호, 메뉴 이름, 가격
public record Menu(
        Integer menuNumber,
        String menuName,
        Integer price
) {
}
