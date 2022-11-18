package bridge.controller;

import bridge.model.validator.BridgeSizeValidator;
import bridge.model.validator.GameCommandValidator;
import bridge.model.validator.NextMoveValidator;
import bridge.model.validator.Validator;
import bridge.view.ErrorMessage;
import bridge.view.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        /*BridgeGame bridgeGame = createNewGame();
        do {

        } while(continue)*/
    }

    public int getBridgeSize() {
        String input = getValidInput(GameMessage.ASK_BRIDGE_SIZE,
                new BridgeSizeValidator(), ErrorMessage.INVALID_BRIDGE_SIZE);
        return Integer.parseInt(input);
    }

    public String getNextMove() {
        return getValidInput(GameMessage.ASK_NEXT_MOVE, new NextMoveValidator(), ErrorMessage.INVALID_NEXT_MOVE);
    }

    public String getGameCommand() {
        return getValidInput(GameMessage.ASK_RETRY, new GameCommandValidator(), ErrorMessage.INVALID_GAME_COMMAND);
    }

    public String getValidInput(GameMessage gameMessage, Validator inputValidator, ErrorMessage errorMessage) {
        String input;
        do {
            outputView.printGameMessage(gameMessage);
            input = inputView.readMoving();
        } while (!validateInput(input, inputValidator, errorMessage));
        return input;
    }

    public boolean validateInput(String input, Validator inputValidator, ErrorMessage errorMessage) {
        try {
            inputValidator.validateInput(input);
            return true;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(errorMessage);
            exception.printStackTrace();
            return false;
        }
    }
}
