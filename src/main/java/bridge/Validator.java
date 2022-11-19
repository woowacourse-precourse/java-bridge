package bridge;

public class Validator {
    private Validator() {}

    public static void size(String size) {
        String sizeRegex = "^([3-9]{1})$|^(1[0-9]{1})$|^20$";
        if (!size.matches(sizeRegex)) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해 주세요");
        }
    }

    public static void direction(String direction) {
        if (!(direction.equals("U") || direction.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 위로가려면 U, 아래로 가려면 D를 입력해 주세요");
        }
    }

    public static void command(String command) {
        if(!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시도를 하려면 R, 종료하려면 Q를 입력해 주세요");
        }
    }
}
