package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.GameRecord;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private GameRecord gameRecord;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        gameRecord = new GameRecord();
    }

    public void start() {
        outputView.printStartGame();
        generateBridge();
        System.out.println();
        do {
            // U, D 입력 받으며 다리 위 이동
            gameRecord.setPlayTimes(gameRecord.getPlayTimes() + 1);
            bridgeGame.generateNewRound();
            play();
        } while (isRetry());
    }

    private void generateBridge() {
        try {
            outputView.printInputBridgeSize();
            int size = inputView.readBridgeSize();
            bridgeGame.generateBridge(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateBridge();
        }
    }

    private void play() {
        try {
            move();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            play();
        }
    }

    private void move() {
        String correctResult;
        do {
            outputView.printMoveCommand();

            correctResult = bridgeGame.move(inputView.readMoving());
            // 현재 까지의 결과 출력
            outputView.printMap(bridgeGame.getGameRound());
        } while (bridgeGame.isBeAbleProceed(correctResult));
    }

    private boolean isRetry() {
        if (isWin()) return false;
        try {
            outputView.printRetryCommand();
            return bridgeGame.retry(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isRetry();
        }
        return true;
    }

    private boolean isWin() {
        if (bridgeGame.isSuccess()) {
            outputView.printResult(bridgeGame.getGameRound(), gameRecord);
            return true;
        }
        return false;
    }
}
