package bridge.game;

import bridge.BridgeRandomNumberGenerator;
import bridge.game.bridgeGame.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Game {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameStatus gameStatus;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private BridgeGame bridgeGame;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameStatus = new GameStatus();
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    }

    public void start() {
        this.outputView.printStart();
        System.out.println();
    }
}
