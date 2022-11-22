package bridge.controller;

import bridge.BridgeMaker;
import bridge.controller.validator.BridgeGameControllerValidator;
import bridge.domain.*;
import bridge.dto.BridgeGameResultDto;
import bridge.dto.BridgeGameLocationDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int triedCount;

    public BridgeGameController(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker) {
        BridgeGameControllerValidator.validate(inputView, outputView, bridgeMaker);
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = initBridge(bridgeMaker);
    }

    private Bridge initBridge(final BridgeMaker bridgeMaker) {
        try {
            outputView.printStartMessage();
            outputView.printAskBridgeLength();
            final int size = inputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(size));
        } catch (final IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return initBridge(bridgeMaker);
        }
    }

    public void gamePlay() {
        BridgeGameCommand playerChoice = BridgeGameCommand.RETRY;
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        while (playerChoice != BridgeGameCommand.QUIT) {
            bridgeGame.retry();
            continuousGame(bridgeGame);
            triedCount++;
            playerChoice = askRetry(bridgeGame);
        }
        gameFinish(bridgeGame);
    }

    private void gameFinish(final BridgeGame bridgeGame) {
        final BridgeGameLocationDto log = BridgeGameLocationDto.of(bridgeGame.printMoveInfo());
        final BridgeGameResult gameResult = bridgeGame.result();
        outputView.printResult(BridgeGameResultDto.of(triedCount, log, gameResult));
    }

    private void continuousGame(final BridgeGame bridgeGame) {
        while (!bridgeGame.isFinish()) {
            final BridgeGamePosition nextPosition = askMove();
            bridgeGame.move(nextPosition);
            outputView.printMap(BridgeGameLocationDto.of(bridgeGame.printMoveInfo()));
        }
    }

    private BridgeGamePosition askMove() {
        try {
            outputView.printMove();
            return BridgeGamePosition.checkBridgePosition(inputView.readMoving());
        } catch (final IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askMove();
        }
    }

    private BridgeGameCommand askRetry(final BridgeGame bridgeGame) {
        if (bridgeGame.result() == BridgeGameResult.SUCCESS) {
            return BridgeGameCommand.QUIT;
        }
        try {
            outputView.printAskRetry();
            return BridgeGameCommand.checkGameCommand(inputView.readGameCommand());
        } catch (final IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askRetry(bridgeGame);
        }
    }
}