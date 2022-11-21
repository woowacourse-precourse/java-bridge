package bridge;

import java.util.StringJoiner;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static StringJoiner upSideBridge = new StringJoiner(" | ", "[ ", " ]");
    private static StringJoiner downSideBridge = new StringJoiner(" | ", "[ ", " ]");
    private static int gameCount;
    private static boolean isPlayerFailed = false;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (moving.equals("U")) {
            upSideBridge.add("O");
            downSideBridge.add(" ");
        }
        if (moving.equals("D")) {
            downSideBridge.add("O");
            upSideBridge.add(" ");
        }
    }

    public void moveFailed(String moving) {
        if (moving.equals("U")) {
            upSideBridge.add("X");
            downSideBridge.add(" ");
        }
        if (moving.equals("D")) {
            downSideBridge.add("X");
            upSideBridge.add(" ");
        }
    }

    // 정답 다리와 맞는지 체크하는 기능
    public boolean checkAnswer(String answer, String moving) {
        if (!answer.equals(moving)) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String doRestart) {
        if (doRestart.equals("Q")) {
            return false;
        }
        upSideBridge = new StringJoiner(" | ", "[ ", " ]");
        downSideBridge = new StringJoiner(" | ", "[ ", " ]");
        return true;
    }

    public void addGameCount() {
        gameCount += 1;
    }

    public void switchResult() {
        isPlayerFailed = !isPlayerFailed;
    }

    public static int getGameCount() {
        return gameCount;
    }

    public static boolean getIsPlayerFailed() {
        return isPlayerFailed;
    }

    public static StringJoiner getUpSideBridge() {
        return upSideBridge;
    }

    public static StringJoiner getDownSideBridge() {
        return downSideBridge;
    }
}
