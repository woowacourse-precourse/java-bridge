package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String REQUEST_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_MOVING_WAY = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_RETRY_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_LENGTH);
        String length = Console.readLine();

        try {
            InputValidator.validateLengthInput(length);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }

        return Integer.parseInt(length);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(REQUEST_MOVING_WAY);
        String moving = Console.readLine();

        try {
            InputValidator.validateMovingInput(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(REQUEST_RETRY_OR_NOT);
        String retry = Console.readLine();

        try {
            InputValidator.validateRetryInput(retry);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }

        return retry;
    }
}
