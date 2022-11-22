package bridge;

public class ValidateBridge {

    static int validateBridgeSize(String beforeValidateSize) {
        int size = 0;
        try {
            size = Integer.parseInt(beforeValidateSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이가 숫자가 아닙니다");
        }

        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하여야 합니다.");
        }
        return size;
    }
}
