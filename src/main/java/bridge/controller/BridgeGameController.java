package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MoveCommandValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;

    public void runGame() {
        try {
            repeatRound();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    public void repeatRound() {
        outputView.printGameStartMessage();
        bridgeGame = new BridgeGame(new BridgeWalker(new MoveRecord(), createBridgeByUserInputSize()));
        RoundResult roundResult;
        do {
            bridgeGame.retry();
            roundResult = runRound();
        } while (!roundResult.equals(RoundResult.CLEAR) && getGameCommand().equals(GameCommand.RESTART));
        outputView.printResult(
                bridgeGame.getClearDescription(), bridgeGame.getGameTryCountDescription(), bridgeGame.getMoveRecord()
        );
    }

    public RoundResult runRound() {
        RoundResult roundResult;
        do {
            roundResult = bridgeGame.move(getMoveCommand());
            outputView.printMap(bridgeGame.getMoveRecord());
        } while (roundResult.equals(RoundResult.PLAYING));
        return roundResult;
    }

    public Bridge createBridgeByUserInputSize() {
        BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
        int bridgeSize = bridgeSizeValidator.getValidBridgeSize(inputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return Bridge.from(bridgeMaker.makeBridge(bridgeSize));
    }

    public String getMoveCommand() {
        MoveCommandValidator moveCommandValidator = new MoveCommandValidator();
        String userMove = moveCommandValidator.getValidCommand(inputView.readMoving());
        return userMove;
    }

    public GameCommand getGameCommand() {

        if (bridgeGame.isClear()) {
            return GameCommand.QUIT;
        }
        GameCommandValidator gameCommandValidator = new GameCommandValidator();
        GameCommand gameCommand = GameCommand.findByCommand(
                gameCommandValidator.getValidCommand(inputView.readGameCommand())
        );
        return gameCommand;
    }
}
