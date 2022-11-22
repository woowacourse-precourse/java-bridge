package bridge.controller;

import bridge.code.BridgeMap;
import bridge.code.GameStatus;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final BridgeGame game;
    private final InputView inputView;
    private final OutputView outputView;

    private GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.game = new BridgeGame(this.inputView.readBridgeSize());
    }

    public static GameController start() {
        return new GameController();
    }

    public void play() {
        while (game.getGameStatus() == GameStatus.PLAY) {
            move();
        }
        end(game.getGameStatus());
    }

    public void move() {
        boolean isMoveSuccess = game.move(inputView.readMoving());
        outputView.printMap(game.getResult());
        if (!isMoveSuccess) {
            retry();
        }
    }

    public void retry() {
        game.retry(inputView.readGameCommand());
    }

    public void end(int gameStatus) {
        outputView.printResult(game.getResult(),
            BridgeMap.FOR_TOTAL.getString(gameStatus == GameStatus.SUCCESS));
    }

}
