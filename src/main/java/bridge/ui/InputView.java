package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final ValidateInput validateInput;

    public InputView(ValidateInput validateInput) {
        this.validateInput = validateInput;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingSpace = Console.readLine();
        validateInput.validateWordLength(movingSpace);
        validateInput.validateMovingSpaceWord(movingSpace);
        return movingSpace;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validateInput.validateWordLength(gameCommand);
        validateInput.validateGameCommandWord(gameCommand);
        return gameCommand;
    }

    /**
     * 사용자에게 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        validateInput.validateNumber(bridgeSizeInput);
        validateInput.validateBridgeSizeLength(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        validateInput.validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }
}
