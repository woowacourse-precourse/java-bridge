package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

public class BridgeGameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = buildGame();
    }

    private BridgeGame buildGame() {
        outputView.printGameStartScript();
        int bridgeSize = selectBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(bridge);
    }

    private int selectBridgeSize() {
        outputView.printBridgeSizeInputScript();
        return inputView.readBridgeSize();
    }

    public void play() {
        while (!bridgeGame.isAllCrossed()) {
            if (playOneStage()) continue;
            if (!retryIf(Objects.equals(selectGameCommand(), "R"))) break;
        }
        printGameResult();
    }

    private boolean playOneStage() {
        String playerMoving = selectMoving();
        boolean isCrossed = bridgeGame.move(playerMoving);
        outputView.printMap(bridgeGame.getCurrentGameStages());
        return isCrossed;
    }

    private String selectMoving() {
        outputView.printMovingInputScript();
        return inputView.readMoving();
    }

    private String selectGameCommand() {
        outputView.printGameCommandInputScript();
        return inputView.readGameCommand();
    }

    private boolean retryIf(boolean isRetry) {
        if (isRetry) bridgeGame.retry();
        return isRetry;
    }

    private void printGameResult() {
        outputView.printGameResultScript();
        outputView.printResult(bridgeGame.isAllCrossed(), bridgeGame.getNumberOfAttempt());
    }
}
