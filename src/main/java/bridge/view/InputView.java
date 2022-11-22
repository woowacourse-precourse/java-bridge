package bridge.view;

import bridge.input.GameCommand;
import bridge.input.UserMove;
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

    public GameCommand reReadGameCommandWhenError() {
        while (true) {
            try {
                return GameCommand.getGameCommand(readGameCommand());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
