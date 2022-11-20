package bridge.View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static int bridgeSize;

    public void inputBridgeSize(){
        bridgeSize = Integer.parseInt(Console.readLine());
        validateSizeNumber(bridgeSize);
    }

    public int readBridgeSize() {
        return 0;
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

    public void validateSizeNumber(int size) {
        if (size < 3 || size > 20  ) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상 20 이하만 가능합니다.");
        }
    }

}
