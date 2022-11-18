package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_LENGTH_QUESTION = "다리의 길이를 입력해주세요.";
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
