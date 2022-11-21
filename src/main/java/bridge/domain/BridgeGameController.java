package bridge.domain;

import bridge.view.InputView;

public class BridgeGameController {
    BridgeGame game;

    public BridgeGameController() {
        game = new BridgeGame();
    }

    public void start() {
        BridgeSize size = new BridgeSize(InputView.readBridgeSize());
        game.setBridge(size);
    }


}
