package bridge.domain;

import bridge.BridgeMaker;
import bridge.dto.BridgeGameResultDto;
import bridge.dto.PlayLogDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class BridgeGameController {

    private static final String INPUT_VIEW_NULL_MESSAGE = "inputView 에는 null 이 올 수 없습니다";
    private static final String OUTPUT_VIEW_NULL_MESSAGE = "outputView 에는 null 이 올 수 없습니다";
    private static final String BRIDGE_MAKER_NULL_MESSAGE = "bridgeMaker 에는 null 이 올 수 없습니다";
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int triedCount = 0;

    public BridgeGameController(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker) {
        validateInputView(inputView);
        validateOutputView(outputView);
        validateBridgeMaker(bridgeMaker);
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = setUpBridge(bridgeMaker);
    }

    private void validateInputView(final InputView inputView) {
        if (inputView == null) {
            throw new IllegalArgumentException(INPUT_VIEW_NULL_MESSAGE);
        }
    }

    private void validateOutputView(final OutputView inputView) {
        if (inputView == null) {
            throw new IllegalArgumentException(OUTPUT_VIEW_NULL_MESSAGE);
        }
    }

    private void validateBridgeMaker(final BridgeMaker bridgeMaker) {
        if (bridgeMaker == null) {
            throw new IllegalArgumentException(BRIDGE_MAKER_NULL_MESSAGE);
        }
    }

    private Bridge setUpBridge(final BridgeMaker bridgeMaker) {
        try {
            outputView.printInitialMessage();
            outputView.printAskBridgeLength();
            final int size = inputView.readBridgeSize();
            BridgeValidator.validateBridgeSize(size);
            return new Bridge(bridgeMaker.makeBridge(size));
        } catch (final IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return setUpBridge(bridgeMaker);
        }
    }

    public void play() {
        ControllerCommand playerChoice = ControllerCommand.RETRY;
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        while (playerChoice != ControllerCommand.QUIT) {
            bridgeGame.retry();
            playOneGame(bridgeGame);
            triedCount++;
            playerChoice = askRetry(bridgeGame);
        }
        finish(bridgeGame);
    }

    private void retryGame(final BridgeGame bridgeGame) {
    private void finish(final BridgeGame bridgeGame) {
        final PlayLogDto log = new PlayLogDto(bridgeGame.toPrintableLog());
        final GameResult gameResult = bridgeGame.result();
        outputView.printResult(new BridgeGameResultDto(triedCount, log, gameResult));
    }

    private void playOneGame(final BridgeGame bridgeGame) {
        while (!bridgeGame.isFinish()) {
            final Position nextPosition = askMoving();
            bridgeGame.move(nextPosition);
            outputView.printMap(new PlayLogDto(bridgeGame.toPrintableLog()));
        }
    }

    private Position askMoving() {
        try {
            outputView.printMoving();
            return Position.from(inputView.readMoving());
        } catch (final IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askMoving();
        }
    }

    private ControllerCommand askRetry(final BridgeGame bridgeGame) {
        if (isGameCleared(bridgeGame)) {
            return ControllerCommand.QUIT;
        }
        try {
            outputView.printAskRetry();
            return ControllerCommand.from(inputView.readGameCommand());
        } catch (final IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askRetry(bridgeGame);
        }
    }

    private boolean isGameCleared(final BridgeGame bridgeGame) {
        return bridgeGame.result() == GameResult.SUCCESS;
    }
}
