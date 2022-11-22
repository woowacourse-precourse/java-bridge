package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int readBridgeSize() {
        return getValidBridgeSize(Console.readLine());
    }

    public String readMoving() {
        String movingPosition = Console.readLine();
        inputValidator.validateMovingPosition(movingPosition);

        return movingPosition;
    }

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
