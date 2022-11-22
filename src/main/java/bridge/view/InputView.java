package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = System.lineSeparator() + "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String WRONG_BRIDGE_SIZE_MESSAGE = "[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.";
    private static final String WRONG_DIRECTION_MESSAGE = "[ERROR] 이동할 칸은 U 또는 D만 입력할 수 있습니다.";
    private static final String WRONG_COMMAND_MESSAGE = "[ERROR] 게임 재시작 여부는 R 또는 Q만 입력할 수 있습니다.";

    public int readBridgeSize() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
        String input = Console.readLine();
        try {
            validateBridgeSize(input);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println(MOVE_INPUT_MESSAGE);
        String input = Console.readLine();
        try{
            validateMoveInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public String readGameCommand() {
        System.out.println(RETRY_INPUT_MESSAGE);
        String input = Console.readLine();
        try {
            validateCommand(input);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public static void validateBridgeSize(String input) {
        if (!input.matches("^[0-9]+") || !isInRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException(WRONG_BRIDGE_SIZE_MESSAGE);
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
            throw new IllegalArgumentException(WRONG_DIRECTION_MESSAGE);
        }
    }

    public static void validateCommand(String input) {
        if (!input.equals("Q") && !input.equals("R")) {
            throw new IllegalArgumentException(WRONG_COMMAND_MESSAGE);
        }
    }
}
