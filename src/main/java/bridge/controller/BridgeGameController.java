package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeWalker;
import bridge.domain.MoveRecord;
import bridge.domain.type.GameCommandType;
import bridge.domain.type.RoundResultType;
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
        RoundResultType roundResultType;
        do {
            bridgeGame.retry();
            roundResultType = runRound();
        } while (!roundResultType.equals(RoundResultType.CLEAR) && getGameCommand().equals(GameCommandType.RESTART));
        outputView.printResult(
                bridgeGame.getClearDescription(), bridgeGame.getGameTryCountDescription(), bridgeGame.getMoveRecord()
        );
    }

    public RoundResultType runRound() {
        RoundResultType roundResultType;
        do {
            roundResultType = bridgeGame.move(getMoveCommand());
            outputView.printMap(bridgeGame.getMoveRecord());
        } while (roundResultType.equals(RoundResultType.PLAYING));
        return roundResultType;
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

    public GameCommandType getGameCommand() {

        if (bridgeGame.isClear()) {
            return GameCommandType.QUIT;
        }
        GameCommandValidator gameCommandValidator = new GameCommandValidator();
        GameCommandType gameCommandType = GameCommandType.findByCommand(
                gameCommandValidator.getValidCommand(inputView.readGameCommand())
        );
        return gameCommandType;
    }
}
