package bridge.controller;

import bridge.GameCommand;
import bridge.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static int getBridgeSize() {
        try {
            outputView.printBridgeSizeInput();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    public static Moving getMoving() {
        try {
            outputView.printMovingInput();
            String mark = inputView.readMoving();
            return Moving.from(mark);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoving();
        }
    }

    public static GameCommand getGameCommand() {
        try {
            outputView.printGameCommandInput();
            String mark = inputView.readGameCommand();
            return GameCommand.from(mark);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getGameCommand();
        }
    }
}
