package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        validateMoveInput(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        validateCommand(input);
        return input;
    }

    public static void validateBridgeSize(String input) {
        if (!input.matches("^[0-9]+") || !isInRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.");
        }
    }

    public static boolean isInRange(int input) {
        if (input >= 3 && input <= 20) {
            return true;
        }
        return false;
    }

    public static void validateMoveInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D만 입력할 수 있습니다.");
        }
    }

    public static void validateCommand(String input) {
        if (!input.equals("Q") && !input.equals("R")) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작 여부는 R 또는 Q만 입력할 수 있습니다.");
        }
    }
}
