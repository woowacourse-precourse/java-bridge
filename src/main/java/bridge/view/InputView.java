package bridge.view;

import bridge.exception.BridgeGameException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeGameException bridgeGameException = new BridgeGameException();
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_GAME_COMMAND = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        try {
            String readLine = Console.readLine();
            bridgeGameException.validateBridgeSize(readLine);
            return Integer.parseInt(readLine);
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String readLine = Console.readLine();
        try {
            bridgeGameException.validateMovingCommand(readLine);
            return readLine;
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        String readLine = Console.readLine();
        try {
            bridgeGameException.validateGameCommand(readLine);
            return readLine;
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }
    }
}
