package bridge.view;


import bridge.exception.BridgeGameInputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeGameInputException bridgeGameInputException = new BridgeGameInputException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String bridgeSize = Console.readLine();
            bridgeGameInputException.validateBridgeSize(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String move = Console.readLine();
            bridgeGameInputException.validateMovingChoice(move);
            return move;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String gameCommand = Console.readLine();
            bridgeGameInputException.validateGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readGameCommand();
    }
}
