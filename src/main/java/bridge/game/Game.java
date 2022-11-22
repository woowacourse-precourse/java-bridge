package bridge.game;

import bridge.BridgeRandomNumberGenerator;
import bridge.game.bridgeGame.BridgeGame;
import bridge.game.bridgeGame.BridgeGameStatus;
import bridge.structure.Bridge;
import bridge.BridgeMaker;
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

    public void isRetry() {
        BridgeGameStatus bridgeGameStatus = this.bridgeGame.getBridgeGameStatus();
        ifCorrect(bridgeGameStatus);
        ifFall(bridgeGameStatus);
    }

    private void ifCorrect(BridgeGameStatus bridgeGameStatus) {
        if (bridgeGameStatus.equals(BridgeGameStatus.CORRECT)) {
            this.gameStatus.end();
        }
    }

    private void ifFall(BridgeGameStatus bridgeGameStatus) {
        if (bridgeGameStatus.equals(BridgeGameStatus.FALL)) {
            this.outputView.printChoiceRestart();
            if (!this.bridgeGame.retry(this.inputView.readGameCommand())) {
                this.gameStatus.end();
            }
            this.gameStatus.again();
        }
    }
    public boolean isQuit() {
        return gameStatus.isEnd();
    }
    public void end() {
        this.outputView.printResult(this.bridgeGame, this.gameStatus.getTryCount());
    }
}
