package bridge.view;

import static bridge.ExceptionConst.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;
    private final Pattern BRIDGE_SIZE_PATTERN = Pattern.compile("\\d*");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = receiveInput();
        validateNumber(input);
        int size = Integer.parseInt(input);
        validateSize(size);
        return size;
    }

    private void validateSize(int size) {
        if (size < MINIMUM_BRIDGE_LENGTH || size > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BRIDGE_LENGTH_3_TO_20);
        }
    }

    private void validateNumber(String input) {
        if (!BRIDGE_SIZE_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ONLY_NUMBER);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = receiveInput();
        validateMoveInput(input);
        return input;
    }

    private void validateMoveInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_U_OR_D);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = receiveInput();
        validateRestartOrQuitInput(input);
        return input;
    }

    private void validateRestartOrQuitInput(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_R_OR_Q);
        }
    }

    private String receiveInput() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input.length() >= 9) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LONG_STRING);
        }
    }
}
