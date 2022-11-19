package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";

    private static final int BRIDGE_MIN_RANGE = 3;
    private static final int BRIDGE_MAX_RANGE = 20;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String inputBridgeSize = Console.readLine();
        validateInputBridgeSize(inputBridgeSize);

        return Integer.parseInt(inputBridgeSize);
    }

    private void validateInputBridgeSize(String inputBridgeSize) {
        validateNumberFormat(inputBridgeSize);
        validateRange(Integer.parseInt(inputBridgeSize));
    }

    private void validateNumberFormat(String inputValue) {
        try {
            Integer.valueOf(inputValue);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateRange(int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_RANGE || bridgeSize > BRIDGE_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
