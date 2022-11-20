package bridge.view;

import bridge.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_LENGTH_QUESTION = "다리의 길이를 입력해주세요.";
    private static final String MOVE_BRIDGE_SPACE_QUESTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_QUESTION = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeCount;

        System.out.println(BRIDGE_LENGTH_QUESTION);
        bridgeCount = Console.readLine();
        validateNumber(bridgeCount);

        return Integer.parseInt(bridgeCount);
    }

    private void validateNumber(String bridgeCount) {
        for (int i = 0; i < bridgeCount.length(); i++) {
            if (bridgeCount.charAt(i) < '0' || bridgeCount.charAt(i) > '9') {
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_IS_ONLY_NUMBER.getErrorMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveBridgeSpace;

        System.out.println(MOVE_BRIDGE_SPACE_QUESTION);
        moveBridgeSpace = Console.readLine();
        validateUpOrDown(moveBridgeSpace);

        return moveBridgeSpace;
    }

    private void validateUpOrDown(String moveBridgeSpace) {
        if (!moveBridgeSpace.equals("U") && moveBridgeSpace.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_BRIDGE_SPACE_IS_U_OR_D.getErrorMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryAnswer;

        System.out.println(RETRY_QUESTION);
        retryAnswer = Console.readLine();
        validateRetryOrQuit(retryAnswer);
        return retryAnswer;
    }

    private void validateRetryOrQuit(String retryAnswer) {
        if (!retryAnswer.equals("R") && !retryAnswer.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_ANSWER_IS_R_OR_Q.getErrorMessage());
        }
    }
}
