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
        String userInputValue = Console.readLine();
        InputValidate.isDigitBridgeSize(userInputValue);
        int bridgeSize = Integer.parseInt(userInputValue);
        InputValidate.isInRangeBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInputValue = Console.readLine();
        InputValidate.isValidMoving(userInputValue);
        return userInputValue;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInputValue = Console.readLine();
        InputValidate.isValidCommand(userInputValue);
        return userInputValue;
    }

}
