package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.GameResult;
import bridge.domain.GameStatus;
import bridge.dto.GameResultDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        try {
            run();
        } catch (IllegalArgumentException ie) {
            outputView.printErrorMessage(ie);
        }
    }

    private void run() {
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        GameResult gameResult;
        do {
            bridgeGame.retry();
            gameResult = play(bridgeGame);
        } while (!isFinish(gameResult.getGameStatus())); // break condition : success, quit
        outputView.printResult(new GameResultDto(gameResult));
    }

    private GameResult play(BridgeGame bridgeGame) {
        GameResult gameResult;
        do {
            gameResult = bridgeGame.move(inputView.readMoving());
            outputView.printMap(new GameResultDto(gameResult));
        } while (isDoing(gameResult.getGameStatus())); // break condition : success, fail
        return gameResult;
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
