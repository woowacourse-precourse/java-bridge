package bridge.controller;

import bridge.domain.Step;
import bridge.service.BridgeGame;
import bridge.domain.GameResult;
import bridge.domain.GameStatus;
import bridge.dto.GameResultDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        try {
            run();
        } catch (IllegalArgumentException ie) {
            outputView.printErrorMessage(ie);
        }
    }

    private void run() {
        BridgeGame bridgeGame = new BridgeGame(getBridgeSize());
        GameResult gameResult;
        do {
            bridgeGame.retry();
            gameResult = play(bridgeGame);
        } while (!isFinish(gameResult.getGameStatus())); // break condition : success, quit
        outputView.printResult(new GameResultDto(gameResult));
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    private GameResult play(BridgeGame bridgeGame) {
        GameResult gameResult;
        do {
            gameResult = bridgeGame.move(getStep());
            outputView.printMap(new GameResultDto(gameResult));
        } while (isDoing(gameResult.getGameStatus())); // break condition : success, fail
        return gameResult;
    }

    private Step getStep() {
        return inputView.readMoving();
    }

    private boolean isDoing(GameStatus gameStatus) {
        return GameStatus.DOING.equals(gameStatus);
    }

    private boolean isFinish(GameStatus gameStatus) {
        if (GameStatus.SUCCESS.equals(gameStatus)) {
            return true;
        }
        return quit();
    }

    private boolean quit() {
        return inputView.readGameCommand().equals("Q");
    }
}
