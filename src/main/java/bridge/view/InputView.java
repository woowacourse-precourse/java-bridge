package bridge.view;

import bridge.util.Log;
import bridge.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_LENGTH_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String BRIDGE_CHOICE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_RETRY_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printMessage(BRIDGE_LENGTH_INPUT_MESSAGE);
        String bridgeSize = Console.readLine();
        return checkBridgeSize(bridgeSize);
    }

    private int checkBridgeSize(String bridgeSize) {
        try {
            InputValidator.checkBridgeSize(bridgeSize);
            return Integer.valueOf(bridgeSize);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printMessage(BRIDGE_CHOICE_INPUT_MESSAGE);
        String movingChoice = Console.readLine();
        return checkReadMoving(movingChoice);
    }

    private String checkReadMoving(String movingChoice) {
        try {
            InputValidator.checkMovingChoice(movingChoice);
            return movingChoice;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        printMessage(GAME_RETRY_INPUT_MESSAGE);
        String retryIntention = Console.readLine();
        return checkRetryIntention(retryIntention);
    }

    private String checkRetryIntention(String retryIntention) {
        try {
            InputValidator.checkRetryIntention(retryIntention);
            return retryIntention;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readGameCommand();
        }
    }

    public void showStartMessage() {
        printMessage(GAME_START_MESSAGE);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
