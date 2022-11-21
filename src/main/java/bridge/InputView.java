package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String inputBridgeSize = Console.readLine();
        validBridgeSize(inputBridgeSize);
        return 0;
    }

    private void validBridgeSize(String inputBridgeSize) {
        if (!Pattern.matches("^[0-9]*$", inputBridgeSize)) {
            throw new IllegalArgumentException();
        }

        int bridgeSize = Integer.parseInt(inputBridgeSize);
        if (bridgeSize < 3 || bridgeSize > 20) {
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
