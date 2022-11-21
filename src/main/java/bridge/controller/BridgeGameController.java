package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class BridgeGameController {

    private static boolean GAME_START = false;

    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;
    private final InputView inputView;

    public BridgeGameController(BridgeGame bridgeGame, BridgeMaker bridgeMaker, OutputView outputView, InputView inputView) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        try {
            List<String> bridge = startGameMakeBridge();
            findCorrectBridge(bridge, GAME_START);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    private void findCorrectBridge(List<String> bridge, boolean gameQuit) {
        while (!gameQuit) {
            List<String> moveResult = moveBridgeResult(bridge);
            if (bridgeGame.isFailGame()) {
                gameQuit = retryOrQuit(bridge, moveResult);
                continue;
            }
            gameQuit = isGameQuitFinal(bridge, moveResult);
        }
    }

    private boolean retryOrQuit(List<String> bridge, List<String> moveResult) {
        outputView.printRetryOrQuitChoice();
        String gameCommand = inputView.readGameCommand();
        moveResult = bridgeGame.retry(gameCommand);
        return isGameQuit(gameCommand, moveResult, bridge);
    }

    private boolean isGameQuitFinal(List<String> bridge, List<String> moveResult) {
        if (!bridgeGame.isFailFinalGame(bridge)) {
            outputView.printResult(moveResult, bridgeGame.isFailFinalGame(bridge),
                    bridgeGame.checkRetryCount());
            return true;
        }
        return false;
    }

    private boolean isGameQuit(String gameCommand, List<String> moveResult, List<String> bridge) {
        if (gameCommand.equals("Q")) {
            outputView.printResult(moveResult, bridgeGame.isFailFinalGame(bridge),
                    bridgeGame.checkRetryCount());
            return true;
        }
        return false;
    }

    private List<String> moveBridgeResult(List<String> bridge) {
        List<String> moveResult;
        outputView.printMovingSpaceChoice();
        String moveSpace = inputView.readMoving();
        moveResult = bridgeGame.move(bridge, moveSpace);
        outputView.printMap(moveResult);
        return moveResult;
    }

    private List<String> startGameMakeBridge() {
        outputView.printGameStart();
        outputView.printBridgeLengthInput();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }
}
