package bridge.domain;

import java.util.Objects;

public class ValidationUtil {
    private static final String INVAILED_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVAILED_MOVE = "[ERROR] U 또는 D로 입력해야 합니다.";

    public static void bridgeSizeValidation(int bridgeSize) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw new IllegalArgumentException(INVAILED_SIZE);
        }
    }

    public static void movedValidation(String move) {
        if(!Objects.equals(move, Constant.MOVED_POSITION_UP) && !Objects.equals(move, Constant.MOVED_POSITION_DOWN)){
            throw new IllegalArgumentException(INVAILED_MOVE);
        }
    }

}
