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
        int bridgeSize = -1;
        try {
            String input = Console.readLine();
            bridgeSize = Util.stringToInteger(input);
        } catch (IllegalArgumentException iae) {
            String errorMessage = iae.getMessage();
            System.out.println(errorMessage);
        }
        return bridgeSize;
    }


}
