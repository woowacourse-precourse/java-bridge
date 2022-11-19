package bridge.game;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.SystemView;

public class GameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final SystemView systemView = new SystemView();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Game game;

    public boolean runGame() {

        systemView.printStartGame();
        game = new Game();
        return game.getRunStatus().isStatus();

    }

    public boolean retryGame() {

        game.setRunStatus(inputView.readGameCommand());
        bridgeGame.retry(game);
        return game.getRunStatus().isStatus();

    }

    public void moveBridge() {

    }

    public void printResultMap() {
        outputView.printGameResultMap();
    }

    public void printResultAndCount() {
        outputView.printGameResultAndCount(game);
    }



}
