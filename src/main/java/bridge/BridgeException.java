package bridge;

public class BridgeException {

    public static int BridgeSizeException(String input) {

        if (!input.matches("[+-]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20 이하 숫자를 입력해주시오.");
        }

        return size;
    }
}
