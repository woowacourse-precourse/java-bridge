package bridge;

/**
 * 사용자의 입력을 검사하는 역할을 한다.
 */
public class InputValidator {

    private static final String RETRY_COMMAND_ERROR = "[ERROR] 입력은 R과 Q 중 하나의 문자여야 합니다.";
    private static final String MOVING_COMMAND_ERROR = "[ERROR] 이동할 칸은 U와 D 중 하나의 문자여야 합니다.";
    private static final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void checkBridgeSize(String input) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR);
        }
        int bridgeSizeInput = Integer.parseInt(input);
        if (bridgeSizeInput < 3 || bridgeSizeInput > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR);
        }
    }

    public void checkMoving(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(MOVING_COMMAND_ERROR);
        }
        if (!input.equals(CommandType.UP.getValue()) && !input.equals(CommandType.DOWN.getValue())){
            throw new IllegalArgumentException(MOVING_COMMAND_ERROR);
        }
    }

    public void checkRetryCommand(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(RETRY_COMMAND_ERROR);
        }
        if (!input.equals(CommandType.RETRY.getValue()) && !input.equals(CommandType.QUIT.getValue())){
            throw new IllegalArgumentException(RETRY_COMMAND_ERROR);
        }
    }

}
