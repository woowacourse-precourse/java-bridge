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

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Constants.CHOOSE_UP_DOWN);
        String moving = Console.readLine();
        movingInput(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Constants.CHOOSE_R_Q);
        String retry = Console.readLine();
        retryInput(retry);
        return retry;
    }

    public void bridgeSizeInput(String input) {
        exception.notNatural(input);
        exception.checkBridgeSize(input);
    }

    public void movingInput(String moving) {
        exception.checkAlphabet(moving);
        exception.checkMoveInput(moving);
    }
}
