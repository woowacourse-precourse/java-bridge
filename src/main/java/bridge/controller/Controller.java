package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.view.*;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    boolean isSuccess = false;


    public void run() {
        outputView.printGameStartMessage();
        final BridgeSize bridgeSize = inputBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(createBridge(bridgeSize));
        while (true) {
            crossingGame(bridgeSize, bridgeGame);
            if (isSuccess || !isGameRetry(bridgeGame)) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getGameResult(), isSuccess, bridgeGame.getNumberOfAttempts());
    }

    private BridgeSize inputBridgeSize() {
        BridgeSize bridgeSize;
        while (true) {
            try {
                bridgeSize = new BridgeSize(inputView.readBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeSize;
    }

    private Bridge createBridge(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize.getBridgeSize()));
    }

    private void crossingGame(BridgeSize bridgeSize, BridgeGame bridgeGame) {
        PlayerMoving playerMoving;
        for (int tryCount = 0; tryCount < bridgeSize.getBridgeSize(); tryCount++) {
            playerMoving = inputPlayerMoving();
            if (!bridgeGame.move(playerMoving)) {
                outputView.printMap(bridgeGame.getGameResult());
                return;
            }
            outputView.printMap(bridgeGame.getGameResult());
        }
        isSuccess = true;
    }

    private PlayerMoving inputPlayerMoving() {
        PlayerMoving playerMoving;
        while (true) {
            try {
                playerMoving = new PlayerMoving(inputView.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return playerMoving;
    }

    private boolean isGameRetry(BridgeGame bridgeGame) {
        PlayerCommand playerCommand = inputPlayerCommand();
        return bridgeGame.retry(playerCommand);
    }

    private PlayerCommand inputPlayerCommand() {
        PlayerCommand playerCommand;
        while (true) {
            try {
                playerCommand = new PlayerCommand(inputView.readGameCommand());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return playerCommand;
    }
}
