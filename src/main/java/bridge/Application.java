package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Bridge {
    private GameUI gameUI;
    private InputView inputView;
    private BridgeMaker bridgeMaker;
    public List<String> gameStart() {
        gameUI.gameStart();
        gameUI.getBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }
}