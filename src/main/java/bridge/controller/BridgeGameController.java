package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

import static bridge.constant.BridgeGameConstant.*;

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
        while (true) {
            try {
                outputView.printBridgeSizeInputScript();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void play() {
        while (!bridgeGame.isAllCrossed()) {
            if (playOneStage()) continue;
            if (!retryIf(Objects.equals(selectGameCommand(), RETRY_COMMAND))) break;
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
        while (true) {
            try {
                outputView.printMovingInputScript();
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String selectGameCommand() {
        while (true) {
            try {
                outputView.printGameCommandInputScript();
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean retryIf(boolean isRetry) {
        if (isRetry) bridgeGame.retry();
        return isRetry;
    }

    private void printGameResult() {
        outputView.printGameResultScript();
        outputView.printMap(bridgeGame.getCurrentGameStages());
        outputView.printResult(bridgeGame.isAllCrossed(), bridgeGame.getNumberOfAttempt());
    }
}
