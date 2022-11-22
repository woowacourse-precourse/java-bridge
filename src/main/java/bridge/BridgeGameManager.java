package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameManager {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";

    private BridgeMaker bridgeMaker = new BridgeMaker(null);
    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();

    private List<String> bridge = new ArrayList<>();
    private int step = 0;

    public void BridgeGameManager() {

    }

    public void GameStart() {
        System.out.println(START_MESSAGE);
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        for (;step < bridge.size();) {
            if (!bridgeGame.move(bridge, inputView.readMoving(), step)) {
                inputView.readGameCommand();
            }
        }

        if (step + 1 == bridge.size()) {

        }

    }

    private void GameRetry() {

    }
}
