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
        try {
            int bridgeSize = Integer.parseInt(readLine());
            bridgeGameInputException.validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력해야합니다.");
        }
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
        return null;
    }
}
