package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Bridge bridge;
    private BridgeGame bridgeGame = new BridgeGame();
    private GameResult gameResult;

    public void run() {
        outputView.printGameStartMessage();
        setBridgeSize();
        boolean retryFlag = true;
        int gameCount = 0;
        while (retryFlag) {
            bridgeGame.initGameResult();
            for (String str : bridge.getShape()) {
                while (true) {
                    try {
                        String inputMove = inputView.readMoving();
                        gameResult = bridgeGame.move(str, inputMove);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                outputView.printMap(gameResult.getUpBridgeResult());
                outputView.printMap(gameResult.getDownBridgeResult());
                if (!gameResult.isBridgeGameResult()) {
                    break;
                }
            }
            gameCount++;
            if (gameResult.isBridgeGameResult()) {
                break;
            }
            while (true) {
                try {
                    retryFlag = bridgeGame.retry(inputView.readGameCommand());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        outputView.printResult(gameResult, checkGameResult(), gameCount);
    }

    public void setBridgeSize() {
        while (true) {
            try {
                bridge = new Bridge(inputView.readBridgeSize());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String checkGameResult() {
        if (gameResult.isBridgeGameResult()) {
            return "성공";
        }
        return "실패";
    }
}
