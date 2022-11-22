package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private InputView inputView;
    private OutputView outputView;
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private GameResult gameResult;
    private boolean retryFlag;
    private String inputMove;
    private int gameCount;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        retryFlag = true;
        gameCount = 0;
    }

    public void run() {
        outputView.printGameStartMessage();
        setBridgeSize();
        startGame();
        outputView.printResult(gameResult, checkGameResult(), gameCount);
    }

    private void setBridgeSize() {
        while (true) {
            try {
                bridge = new Bridge(inputView.readBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputView.printEmptyLine();
    }

    private void startGame() {
        while (retryFlag) {
            playGame();
            gameCount++;
            if (gameResult.isBridgeGameResult()) {
                break;
            }
            setRetryOrEnd();
        }
    }

    private void playGame() {
        bridgeGame.initGameResult();
        for (String str : bridge.getShape()) {
            setMove(str);
            outputView.printMap(gameResult.getUpBridgeResult());
            outputView.printMap(gameResult.getDownBridgeResult());
            outputView.printEmptyLine();
            if (!gameResult.isBridgeGameResult()) {
                break;
            }
        }
    }

    private void setMove(String str) {
        while (true) {
            try {
                inputMove = inputView.readMoving();
                gameResult = bridgeGame.move(str, inputMove);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setRetryOrEnd() {
        while (true) {
            try {
                retryFlag = bridgeGame.retry(inputView.readGameCommand());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String checkGameResult() {
        if (gameResult.isBridgeGameResult()) {
            return "성공";
        }
        return "실패";
    }
}
