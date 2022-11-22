package bridge;

public class Utility {

    public static void intValidate(String s) {
        if (!s.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력 값입니다.");
        }
    }
}
