package bridge.game;

import bridge.BridgeRandomNumberGenerator;
import bridge.game.bridgeGame.BridgeGame;
import bridge.game.bridgeGame.BridgeGameStatus;
import bridge.structure.Bridge;
import bridge.structure.BridgeMaker;
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

    public void initBridgeGame() {
        this.outputView.printInputSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(this.inputView.readBridgeSize()));
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void playBridgeGame() {
        while (!bridgeGame.getBridgeGameStatus()
                .isContinue()) {
            this.outputView.printInputMove();
            this.bridgeGame.move(this.inputView.readMoving());
            this.outputView.printMap(this.bridgeGame.getBridgeResults());
            System.out.println();
        }
    }

}
