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

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.printGameMessage(GameMessage.START);
        BridgeGame bridgeGame = createNewGame();
        runGame(bridgeGame);
        endGame(bridgeGame);
    }

    public void runGame(BridgeGame bridgeGame) {
        do {
            do {
                bridgeGame.move(getNextMove());
                outputView.printMap(bridgeGame.getUpperMap(), bridgeGame.getLowerMap());
            } while (bridgeGame.canTakeNextMove());
        } while (checkRetry(bridgeGame));
    }

    public void endGame(BridgeGame bridgeGame) {
        outputView.printGameMessage(GameMessage.RESULT_HEADER);
        outputView.printMap(bridgeGame.getUpperMap(), bridgeGame.getLowerMap());
        outputView.printResult(bridgeGame.hasReachedEnd(), bridgeGame.getNumberOfAttempts());
    }

    public BridgeGame createNewGame() {
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initializeGame(bridge);
        return bridgeGame;
    }

    public boolean checkRetry(BridgeGame bridgeGame) {
        if (bridgeGame.hasReachedEnd() || getGameCommand().equals(GameCommand.QUIT.getValue())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    public int getBridgeSize() {
        String input;
        do {
            outputView.printGameMessage(GameMessage.ASK_BRIDGE_SIZE);
            input = inputView.readBridgeSize();
            outputView.printEmptyLine();
        } while (isInvalidInput(input, new BridgeSizeValidator(), ErrorMessage.INVALID_BRIDGE_SIZE));
        return Integer.parseInt(input);
    }

    public String getNextMove() {
        String input;
        do {
            outputView.printGameMessage(GameMessage.ASK_NEXT_MOVE);
            input = inputView.readMoving();
        } while (isInvalidInput(input, new NextMoveValidator(), ErrorMessage.INVALID_NEXT_MOVE));
        return input;
    }

    public String getGameCommand() {
        String input;
        do {
            outputView.printGameMessage(GameMessage.ASK_RETRY);
            input = inputView.readGameCommand();
        } while (isInvalidInput(input, new GameCommandValidator(), ErrorMessage.INVALID_GAME_COMMAND));
        return input;
    }

    public boolean isInvalidInput(String input, Validator inputValidator, ErrorMessage errorMessage) {
        try {
            inputValidator.validateInput(input);
            return false;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(errorMessage);
            exception.printStackTrace();
            return true;
        }
    }
}
