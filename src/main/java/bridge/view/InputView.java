package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BRIDGE_SIZE_FORM_ERROR = "[ERROR] 2자리의 숫자로 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = input();
        validateBridgeSizeInput(bridgeSizeInput);
        return Integer.valueOf(bridgeSizeInput);
    }

    private void validateBridgeSizeInput(String bridgeSizeInput) {
        // TODO: 다리 길이 입력 형식적 검증
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

    private String input() {
        return Console.readLine();
    }
}
