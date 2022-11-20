package bridge;

public class Validation {

    // 입력받은 값이 숫자인지 검증하는 기능
    public static void isDigit(String bridgeSize) {
        for (char c : bridgeSize.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
    }

}
