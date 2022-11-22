package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeCommand = inputBridgeSizeCommand();
        return toBridgeSize(bridgeSizeCommand);
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
     * input: 데이터를 Console에서 입력받는다.
     */
    private String inputBridgeSizeCommand() {
        return Console.readLine();
    }

    private int toBridgeSize(String bridgeSizeCommand) {
        return Integer.parseInt(bridgeSizeCommand);
    }
}
