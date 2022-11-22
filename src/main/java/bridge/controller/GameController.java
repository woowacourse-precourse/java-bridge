package bridge.controller;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.MoveIndicator.DOWN;
import static bridge.domain.MoveIndicator.UP;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private boolean gameFlag;

    public GameController() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameFlag = true;
    }

    public void execute() {
        Game game = new Game(inputView.readBridgeSize());
        while (gameFlag) {
            game.setFinalResult(playGame(game));
            game.increaseAttempt();
            gameFlag = replay(game);
        }
        outputView.printFinalMap(game.getBridges());
        outputView.printResult(game.checkFinalResult(), game.getTotalAttempts());
    }

    public boolean playGame(Game game) {
        game.setBridges(List.of(new Bridge(UP), new Bridge(DOWN)));
        for (String accessibleDirection : game.getDirections()) {
            String userDirection = inputView.readMoving();
            playSingleGame(userDirection, accessibleDirection, game.getBridges());
            if (!userDirection.equals(accessibleDirection)) { return false; }
        }
        return true;
    }

    public void playSingleGame(String userDirection, String accessibleDirection, List<Bridge> bridges) {
        outputView.printMap(bridgeGame.move(userDirection, accessibleDirection, bridges));
    }

    public boolean replay(Game game) {
        if (!game.checkFinalResult()) {
            return bridgeGame.retry(game, inputView.readGameCommand());
        }
        return false;
    }
}
