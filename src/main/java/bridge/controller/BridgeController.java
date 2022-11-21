package bridge.controller;

import bridge.domain.GameStatus;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void createBridge() {
        bridgeGame.initBridge(readBridgeSize());
    }

    public void move() {
        bridgeGame.move(readMoving());

        List<List<String>> result = bridgeGame.getResult();
        outputView.printMap(result.get(0), result.get(1));
    }

    public boolean isGameOver(){
        GameStatus currentStatus = bridgeGame.getCurrentStatus();

        if(currentStatus.equals(GameStatus.OVER) && readRestartOption()) {
            bridgeGame.retry();
            currentStatus = GameStatus.CONTINUE;
        }

        return !currentStatus.equals(GameStatus.CONTINUE);
    }

    public void gameOver() {
        int attempts = bridgeGame.getAttempts();
        List<List<String>> result = bridgeGame.getResult();
        GameStatus gameStatus = bridgeGame.getCurrentStatus();

        outputView.printResult(attempts, result, gameStatus);
    }

    /**
     * InputView 예외처리 메서드
     */

    private int readBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    private String readMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    private boolean readRestartOption() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }
}
