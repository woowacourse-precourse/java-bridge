package bridge.UI;

import static bridge.Messages.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        if (3 > Integer.parseInt(bridgeSize) || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_UP_DOWN);
        String inputMoving = Console.readLine();
        validateMoving(inputMoving);
        return inputMoving;
    }

    private void validateMoving(String inputMoving) {
        if (!inputMoving.equals(UP_DIRECTION) && !inputMoving.equals(DOWN_DIRECTION)) {
            throw new IllegalArgumentException("U와 D만 입력 가능합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY_QUIT);
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(RETRY) && !gameCommand.equals(QUIT)) {
            throw new IllegalArgumentException("R과 Q만 입력 가능합니다.");
        }
    }
}
