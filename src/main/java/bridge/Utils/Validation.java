package bridge.Utils;

/**
 * 사용자의 입력을 확인하고 에러를 발생시킨다.
 */
public class Validation {

    public int checkSizeReturnInt(String size) {
        int parsedSize = 0;

        try {
            parsedSize = Integer.parseInt(size);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("[ERROR] 숫자만 입력이 가능합니다.");
        }

        if (3 > parsedSize || parsedSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3~20칸이여야 합니다.");
        }

        return Integer.parseInt(size);
    }

}
