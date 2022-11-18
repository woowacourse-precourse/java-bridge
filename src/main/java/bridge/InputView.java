package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return bridgeSizeValidate(Console.readLine());
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

    private int bridgeSizeValidate(String inputBridgeSize) {
        if (!inputBridgeSize.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 할 수 있습니다.");
        }
        int inputBridgeSizeToDigit = Integer.parseInt(inputBridgeSize);
        if (inputBridgeSizeToDigit < 3 || 20 < inputBridgeSizeToDigit) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하의 정수만 입력 할 수 있습니다.");
        }
        return inputBridgeSizeToDigit;
    }
}
