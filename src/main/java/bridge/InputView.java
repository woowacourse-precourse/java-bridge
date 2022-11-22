package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
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

    /**
     * 다리의 길이가 올바르게 입력되었는지 검사한다.
     */
    private void validateBridgeSize(String bridgeSize) {
        if (Pattern.matches("^[0-9]+$", bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하십시오.");
        }
        int number = Integer.parseInt(bridgeSize);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 값을 입력하십시오.");
        }
    }
}
