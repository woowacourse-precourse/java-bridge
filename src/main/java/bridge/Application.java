package bridge;

import bridge.game.BridgeGame;
import bridge.message.GameMessage;
import bridge.validation.InputValidation;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.StringJoiner;

public class Application {

    private static final InputValidation inputValidation = new InputValidation();
    private static final InputView inputView = new InputView();
    private static BridgeGame game;

    public static void main(String[] args) {
        System.out.println(GameMessage.START_MSG);
        game = new BridgeGame();
        boolean progress = true;
        while (progress) {
            progress = game.move();
        }

    }

    public static String sizeValidation() {
        try {
            String input = inputView.readBridgeSize();
            inputValidation.bridgeSizeValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            return sizeValidation();
        }
    }

    public static String moveValidation() {
        try {
            String input = inputView.readMoving();
            inputValidation.bridgeMoveValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            return moveValidation();
        }
    }

    public static String retryValidation() {
        try {
            String input = inputView.readGameCommand();
            inputValidation.retryValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            return retryValidation();
        }
    }

}
