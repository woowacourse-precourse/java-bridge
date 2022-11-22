package bridge.exception;

public class BridgeGameException {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String RESTART_GAME = "R";
    private static final String END_GAME = "Q";
    private static final String ONLY_CONTAINS_NUMBER_REGEX = "^[0-9]*$";
    private static final String RANGE_ERROR = "[ERROR] 3에서 20까지의 숫자를 입력해 주시기 바랍니다.";
    private static final String NUMBER_ERROR = "[ERROR] 올바른 숫자가 아닙니다.";
    private static final String MOVING_COMMAND_ERROR = "[ERROR] 입력은 대문자 'U' 또는 'D'를 입력해 주시기 바랍니다.";
    private static final String RETRY_COMMAND_ERROR = "[ERROR] 입력은 대문자 'R' 또는 'Q'를 입력해 주시기 바랍니다.";

    public void validateBridgeSize(String readLine) {
        validateType(readLine);
        validateBlank(readLine);
        validateRange(readLine);
    }

    private void validateType(String readLine) {
        if (!readLine.matches(ONLY_CONTAINS_NUMBER_REGEX)) {
            System.out.println(NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void validateBlank(String readLine) {
        if (readLine.equals("")) {
            System.out.println(RANGE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void validateRange(String readLine) {
        int readLength = Integer.parseInt(readLine);
        if (readLength > MAX_BRIDGE_SIZE || readLength < MIN_BRIDGE_SIZE) {
            System.out.println(RANGE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void validateMovingCommand(String readLine) {
        if (!(UP_BRIDGE.equals(readLine) || DOWN_BRIDGE.equals(readLine))) {
            System.out.println(MOVING_COMMAND_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void validateGameCommand(String readLine) {
        if (!(RESTART_GAME.equals(readLine) || END_GAME.equals(readLine))) {
            System.out.println(RETRY_COMMAND_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
