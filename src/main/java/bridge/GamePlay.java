package bridge;

import bridge.presentation.InputView;
import bridge.presentation.OutputView;

public class GamePlay {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private int tryCount;
    private final boolean WON = true;
    private final boolean FAILURE = false;

    public void initGame() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        tryCount = 0;
    }
}