package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.constant.Constants.*;

public class GameControl {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameControl() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void startGame() {
        OutputView.printGameMessage(GAME_START_MESSAGE + "\n");
        int size = inputView.readBridgeSize();
        bridgeGame.initBridge(size);
    }

}
