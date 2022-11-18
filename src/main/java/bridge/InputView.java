package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String sizePattern = "^[0-9]+$";
    private final String movePattern = "^[U|D]";
    private final String commandPattern = "^[R|Q]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String inputSize = Console.readLine();
        if (!(Pattern.matches(sizePattern, inputSize))) {
            throw new IllegalArgumentException(Message.INPUT_IS_NOT_NUMBER);
        }
        int size = Integer.parseInt(inputSize);
        if (size < Message.MIN_BRIDGE_SIZE || size > Message.MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Message.INPUT_CORRECT_RANGE_OF_NUMBER);
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMove = Console.readLine();
        if (!(Pattern.matches(movePattern, inputMove))) {
            throw new IllegalArgumentException(Message.INPUT_U_OR_D);
        }
        return inputMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputCommand = Console.readLine();
        if (!(Pattern.matches(commandPattern, inputCommand))) {
            throw new IllegalArgumentException(Message.INPUT_R_OR_Q);
        }
        return inputCommand;
    }
}
