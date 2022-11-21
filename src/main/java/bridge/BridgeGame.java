package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static List<String> move(List<String> bridge, boolean isUpper, String input) {
        bridge.add(isBlank(isUpper, input));
        return bridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(String command) {
        return command.equals("R");
    }

    public static int countGameNum(String command, int cnt) {
        if (command.equals("R")) {
            return cnt + 1;
        }
        return cnt;
    }

    public static String canGo(boolean equals) {
        if (equals) {
            return "O";
        }
        return "X";
    }

    public static boolean upperOrLower(String userChoice) {
        return userChoice.equals("U");
    }

    public static String isBlank(boolean isUpper, String s) {
        if (isUpper) {
            return s;
        }
        return " ";
    }
}