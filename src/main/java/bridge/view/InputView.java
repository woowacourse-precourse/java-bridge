package bridge.view;

import bridge.validate.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        Validator.isNum(bridgeSize);
        Validator.isProperBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public int reReadBridgeSizeWhenError() {
        while (true) {
            try {
                return readBridgeSize();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    public String readMoving() {
        String move = Console.readLine();
        Validator.isMove(move);
        return move;
    }

    public UserMove reReadMovingWhenError() {
        while (true) {
            try {
                return UserMove.getUserMove(readMoving());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        Validator.isProperGameCommand(gameCommand);
        return gameCommand;
    }

    public String reReadGameCommandWhenError() {
        while (true) {
            try {
                return readGameCommand();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
