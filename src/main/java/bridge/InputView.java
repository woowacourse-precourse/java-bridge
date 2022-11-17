package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public Integer readBridgeSize() {
        String input = readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 입력받은 다리의 길이를 검증한다.
     */
    private void validateBridgeSize(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if (size < 3 || size > 20) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
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
