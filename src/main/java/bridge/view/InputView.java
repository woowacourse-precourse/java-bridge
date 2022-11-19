package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String SIZE_INPUT= "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String SIZE_INPUT_TYPE_ERROR = "[ERROR] 숫자를 입력해주세요";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String MOVE_MESSAGE_ERROR = "[ERROR] 이동할 칸은 U(위)와 D(아래)만 입력하여야 합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(SIZE_INPUT);

        int bridgeSize = convertToInt(readPlayerInput());
        checkSizeRange(bridgeSize);

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
        if (!(moveMessage.equals("U") || moveMessage.equals("D"))) {
            throw new IllegalArgumentException(MOVE_MESSAGE_ERROR);
        }

        return moveMessage;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String readPlayerInput() {
        return Console.readLine();
    }
}
