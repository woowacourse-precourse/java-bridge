package bridge.game;

import bridge.bridge.Bridge;
import bridge.config.BridgeStatus;
import bridge.config.GameResultStatus;
import bridge.config.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.SystemView;

import java.util.List;

import static bridge.config.BaseException.INVALID_INPUT;
import static bridge.config.GameResultStatus.X;

public class GameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final SystemView systemView = new SystemView();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Game game;

    public Game runGame() {

        systemView.printStartGame();
        game = new Game();
        return game;

    }

    public void retryGame() {
        try {
            game.setRunStatus(inputView.readGameCommand());
            bridgeGame.retry(game);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public GameResultStatus moveBridge(Bridge bridge) {
        GameResultStatus gameResultStatus = bridgeGame.move(bridge);
        return gameResultStatus;
    }

    public void printResultMap(Bridge bridge) {
        outputView.printGameResultMap(bridge);
    }

    public void printGameResult() {
        outputView.printGameResultAndCount(game);
    }


    public void checkSuccess(Game game, Bridge bridge) {

        if (bridge.getPosition() >= bridge.getSize()) {
            if (!bridge.getBridge().contains(X)) {
                game.setGameStatus(GameStatus.SUCCESS);
            }
            game.setRunStatus("Q");
            outputView.printGameResultAndCount(game);
        }

    }
}
