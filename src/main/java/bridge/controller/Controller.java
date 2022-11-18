package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.constant.GameCommand;
import bridge.model.validator.BridgeSizeValidator;
import bridge.model.validator.GameCommandValidator;
import bridge.model.validator.NextMoveValidator;
import bridge.model.validator.Validator;
import bridge.view.constant.ErrorMessage;
import bridge.view.constant.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        BridgeGame bridgeGame = createNewGame();
        runGame(bridgeGame);
    }

    public void runGame(BridgeGame bridgeGame) {
        do {
            do {
                bridgeGame.move(getNextMove());
                outputView.printMap(bridgeGame);
            } while (bridgeGame.canPlayerTakeNextStep());
            if (bridgeGame.hasPlayerReachedEnd()) {
                break;
            }
            bridgeGame.retry();
        } while (getGameCommand().equals(GameCommand.RETRY.getValue()));
    }

    public BridgeGame createNewGame() {
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initializeBridge(bridge);
        bridgeGame.createNewPlayer();
        return bridgeGame;
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
