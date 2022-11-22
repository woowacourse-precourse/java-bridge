package bridge.view;

import bridge.util.BridgeSizeValidator;
import bridge.util.CommandValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final OutputView outputView = new OutputView();
    private final BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
    private final CommandValidator commandValidator = new CommandValidator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            outputView.printMapInputMessage();
            String bridgeSize = Console.readLine();
            bridgeSizeValidator.run(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            outputView.printMoveMessage();
            String moveCommand = Console.readLine();
            commandValidator.validate(moveCommand);
            return moveCommand;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        outputView.printRetryMessage();
        String retryCommand = Console.readLine();
        commandValidator.retryValidate(retryCommand);
        if (retryCommand.equals("R")) {
            return true;
        }
        return false;
    }
}
