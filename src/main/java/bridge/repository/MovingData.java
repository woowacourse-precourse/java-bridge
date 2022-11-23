package bridge.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임의 유저 입력 값을 저장하는 클래스
 */

public class MovingData {

    private static final List<String> playerMoving = new ArrayList<>();

    public static void add(String moving) {
        playerMoving.add(moving);
    }

    public static void resetLastMove() {
        playerMoving.remove(getLastIndex());
    }

    public static int getLastIndex() {
        if (playerMoving.size() == 0) {
            return 0;
        }
        return playerMoving.size() - 1;
    }

    public static int getSize() {
        return playerMoving.size();
    }

    public static void reset() {
        playerMoving.clear();
    }

}
