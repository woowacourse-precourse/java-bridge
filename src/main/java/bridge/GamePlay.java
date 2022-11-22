package bridge;

import bridge.presentation.InputView;
import bridge.presentation.OutputView;

import java.util.List;

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

    public void gameStart() {
        int bridgeSize = createBridgeSize();

        BridgeMaker bridgeMaker = createBridgeMaker();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        PlayerMap playerMap = new PlayerMap(bridgeSize);

        gamePlay(bridge, playerMap);
    }

    private BridgeMaker createBridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

    public void gamePlay(List<String> bridge, PlayerMap playerMap) {
        ++tryCount;
        boolean isWon = playTotalGame(bridge, playerMap);

        printGameResult(isWon, playerMap);
    }

    private boolean playTotalGame(List<String> bridge, PlayerMap playerMap) {
        while (true) {
            if (isGameWon(bridge, playerMap)) {
                return WON;
            }
            if (!isRetry()) {
                return FAILURE;
            }
            resetPrev(playerMap);
        }
    }

    private void resetPrev(PlayerMap playerMap) {
        bridgeGame.resetPrev(playerMap);
        ++tryCount;
    }
}