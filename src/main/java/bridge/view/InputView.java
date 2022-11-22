package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String SIZE_INPUT= "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_INPUT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String SIZE_INPUT_TYPE_ERROR = "[ERROR] 숫자를 입력해주세요\n";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n";
    private static final String MOVE_MESSAGE_ERROR = "[ERROR] 이동할 칸은 U(위)와 D(아래)만 입력하여야 합니다.\n";
    private static final String RETRY_MESSAGE_ERROR = "[ERROR] R(재시도)와 Q(종료)만 입력하여야 합니다.\n";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(SIZE_INPUT);
        int bridgeSize;
        try{
            bridgeSize = convertToInt(readPlayerInput());
            checkSizeRange(bridgeSize);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return readBridgeSize();
        }
        return bridgeSize;
    }

    private int convertToInt(String input) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(SIZE_INPUT_TYPE_ERROR);
        }
        return bridgeSize;
    }

    private void checkSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT);
        String moveMessage = readPlayerInput();
        try {
            checkMoveMessageValid(moveMessage);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return readMoving();
        }
        return moveMessage;
    }

    private void checkMoveMessageValid(String moveMessage) {
        if (!(moveMessage.equals(UP_BRIDGE) || moveMessage.equals(DOWN_BRIDGE))) {
            throw new IllegalArgumentException(MOVE_MESSAGE_ERROR);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_INPUT);
        String retryMessage = readPlayerInput();
        try {
            checkRetryMessageValid(retryMessage);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return readGameCommand();
        }
        return retryMessage;
    }

    private void checkRetryMessageValid(String retryMessage) {
        if (!(retryMessage.equals(RETRY) || retryMessage.equals(QUIT))) {
            throw new IllegalArgumentException(RETRY_MESSAGE_ERROR);
        }
    }

    private String readPlayerInput() {
        return Console.readLine();
    }
}
