package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.type.GameCommandType;
import bridge.domain.type.RoundResultType;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.CommandValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MoveCommandValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void runGame() {
        outputView.printGameStartMessage();
        bridgeGame = BridgeGame.from(createBridgeByUserInputSize());
        runRound();
        outputView.printResult(
                bridgeGame.getClearDescription(), bridgeGame.getGameTryCountDescription(), bridgeGame.getMoveRecord()
        );
    }

    private void runRound() {
        try {
            repeatRound();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void repeatRound() {
        moveUntilRoundExit();
        while (!bridgeGame.isClear() && isRestart()) {
            bridgeGame.retry();
            moveUntilRoundExit();
        }
    }

    private void moveUntilRoundExit() {
        RoundResultType roundResultType;
        do {
            roundResultType = bridgeGame.move(getMoveCommand());
            outputView.printMap(bridgeGame.getMoveRecord());
        } while (roundResultType.equals(RoundResultType.PLAYING));
    }

    private boolean isRestart() {
        return getGameCommand().equals(GameCommandType.RESTART);
    }

    private Bridge createBridgeByUserInputSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return Bridge.from(bridgeMaker.makeBridge(inputBridgeSizeByUser()));
    }

    private int inputBridgeSizeByUser() {
        String inputBridgeSize;
        BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
        do {
            inputBridgeSize = inputView.readBridgeSize();
        } while (!isValidBridgeSize(inputBridgeSize));
        return bridgeSizeValidator.getValidBridgeSize(inputBridgeSize);
    }

    private boolean isValidBridgeSize(String bridgeSize) {
        BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
        try {
            bridgeSizeValidator.getValidBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private String getMoveCommand() {
        CommandValidator moveCommandValidator = new MoveCommandValidator();
        String moveCommand;
        do {
            moveCommand = inputView.readMoving();
        } while (!isErrorCommand(moveCommand, moveCommandValidator));
        return moveCommand;
    }

    private GameCommandType getGameCommand() {
        if (bridgeGame.isClear()) {
            return GameCommandType.QUIT;
        }
        CommandValidator gameCommandValidator = new GameCommandValidator();
        String gameCommand;
        do {
            gameCommand = inputView.readGameCommand();
        } while (!isErrorCommand(gameCommand, gameCommandValidator));
        return GameCommandType.findByCommand(gameCommand);
    }

    private boolean isErrorCommand(String command, CommandValidator commandValidator) {
        try {
            commandValidator.getValidCommand(command);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }
}