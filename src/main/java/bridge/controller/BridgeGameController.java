package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.GameStatus;
import bridge.model.PresentBridgeMaker;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGameController {

    private GameStatus gameStatus;
    private BridgeMaker bridgeMaker;
    private PresentBridgeMaker presentBridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        this.gameStatus = new GameStatus();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.presentBridgeMaker = new PresentBridgeMaker();
        this.bridgeGame = new bridge.model.BridgeGame(gameStatus, bridgeMaker,
            presentBridgeMaker);
    }

    public void startGame() {
        try {
            bridgeGame.initGame();
            bridgeGame.startGame();
            bridgeGame.endGame();
        } catch (IllegalArgumentException ex) {
            OutputView.printErrorMessage(ex.getMessage());
        }
    }
}
