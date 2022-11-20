package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return getValidBridgeSize(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingPosition = Console.readLine();
        inputValidator.validateMovingPosition(movingPosition);

        return movingPosition;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        inputValidator.validateGameCommand(gameCommand);

        return gameCommand;
    }

    private int getValidBridgeSize(String bridgeSize) {
        inputValidator.validateNumberType(bridgeSize);
        inputValidator.validateZeroPrefix(bridgeSize);

        int bridgeSizeNumber = Integer.parseInt(bridgeSize);
        inputValidator.validateBridgeSize(bridgeSizeNumber);

        return bridgeSizeNumber;
    }
}
