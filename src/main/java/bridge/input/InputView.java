package bridge.input;

import bridge.output.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        while (true) {
            OutputView.printReadBridgeSizeMessage();
            String bridgeSize = Console.readLine();

            try {
                Validator.bridgeSize(bridgeSize);
                return Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                OutputView.printReadBridgeSizeErrorMessage();
            }
        }
    }

    public String readMoving() {
        while (true) {
            OutputView.printReadMovingMessage();
            String moving = Console.readLine();

            try {
                Validator.moving(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                OutputView.printReadMovingErrorMessage();
            }
        }
    }

    public String readGameCommand() {
        while (true) {
            OutputView.printReadGameCommandMessage();
            String gameCommand = Console.readLine();

            try {
                Validator.gameCommand(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                OutputView.printReadGameCommandErrorMessage();
            }
        }
    }
}
