package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private GameStatus gameStatus;
    private Bridge bridge;
    private Bridge copyBridge;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        gameStatus = new GameStatus();
    }

    public void start() {
        outputView.askBridgeSize();
        int bridgeLength = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeLength));
        copyBridge = new Bridge(bridge.copyBridge());

        outputView.printStart();

        while (true) {
            outputView.askSpaceToMove();
            String moving = inputView.readMoving();
            boolean check = bridgeGame.move(gameStatus, copyBridge, moving);
            String retry = "R";
            outputView.printMap(gameStatus);

            if (!check) {
                outputView.askWhetherToRetry();
                retry = inputView.readGameCommand();

                if (retry.equals("R")) {
                    gameStatus.resetGameStatus();
                    copyBridge = new Bridge(bridge.copyBridge());
                    gameStatus.tryCount += 1;
                }
            }

            if (retry.equals("Q")) {
                break;
            }

            if (copyBridge.getBridge().size() == 0) {
                gameStatus.gameResult = "성공";
                break;
            }
        }
        outputView.printResult(gameStatus);
    }
}