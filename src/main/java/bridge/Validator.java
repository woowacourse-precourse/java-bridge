package bridge;

public final class Validator {
    private static final String PREFIX = "[ERROR] ";
    private static final String BLANK_STRING = PREFIX + "공백일 수 없습니다.";
    private static final String NOT_INTEGER = PREFIX + "숫자만 입력해 주세요.";
    private static final String INVALID_BRIDGE_LENGTH = PREFIX + "3이상, 20이하 숫자를 입력해 주세요.";
    private static final String INVALID_COMMAND_LENGTH = PREFIX + "이동할 칸/재시작 및 종료 여부는 한 글자만 입력해 주세요.(이동할 칸 - U, D / 재시작 및 종료 여부 - R / Q)";
    private static final String INVALID_MOVING_COMMAND = PREFIX + "U, D 중 한 글자만 입력해 주세요.";
    private static final String INVALID_GAME_COMMAND = PREFIX + "R, Q 중 한 글자만 입력해 주세요.";

    private Validator() {

    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_STRING);
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    public static void validateBridgeLength(String input) {
        if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException(INVALID_BRIDGE_LENGTH);
        }
    }

    public static void validateCommandLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(INVALID_COMMAND_LENGTH);
        }
    }

    public static void validateMovingCommand(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(INVALID_MOVING_COMMAND);
        }
    }

    public static void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND);
        }
    }
}
