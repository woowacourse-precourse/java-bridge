package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final Exception exception = new Exception();

    public void startBridge() {
        System.out.println(Constants.BRIDGE_GAME_START);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Constants.INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        bridgeSizeInput(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

}
