package bridge.input;

import bridge.output.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        String bridgeSize = null;
        boolean isValid = false;

        while (!isValid) {
            OutputView.printReadBridgeSizeMessage();
            bridgeSize = Console.readLine();
            isValid = isValidBridgeSize(bridgeSize);
        }

        return Integer.parseInt(bridgeSize);
    }

    public static String readMoving() {
        String moving = null;
        boolean isValid = false;

        while (!isValid) {
            OutputView.printReadMovingMessage();
            moving = Console.readLine();
            isValid = isValidMoving(moving);
        }

        return moving;
    }

    public static String readGameCommand() {
        String gameCommand = null;
        boolean isValid = false;

        while (!isValid) {
            OutputView.printReadGameCommandMessage();
            gameCommand = Console.readLine();
            isValid = isValidGameCommand(gameCommand);
        }

        return gameCommand;
    }

    private static boolean isValidBridgeSize(String bridgeSize) {
        try {
            Validator.bridgeSize(bridgeSize);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printReadBridgeSizeErrorMessage();
            return false;
        }
    }

    private static boolean isValidMoving(String moving) {
        try {
            Validator.moving(moving);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printReadMovingErrorMessage();
            return false;
        }
    }

    private static boolean isValidGameCommand(String gameCommand) {
        try {
            Validator.gameCommand(gameCommand);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printReadGameCommandErrorMessage();
            return false;
        }
    }
}
