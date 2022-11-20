package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.exception.BridgeGameInputException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeGameInputException bridgeGameInputException = new BridgeGameInputException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = readLine();
        bridgeGameInputException.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = readLine();
        bridgeGameInputException.validateMovingChoice(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = readLine();
        bridgeGameInputException.validateGameCommand(gameCommand);
        return gameCommand;
    }
}
