package bridge;

import java.util.List;

public class Controller {
    private InputView inputView = new InputView();
    private int bridgeSize;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private GameManagement gameManagement = new GameManagement();
    private List<String> bridge;
    private String[][] bridgeBoard;

    public void start() {
        makeBridgeSize();
        if (bridgeSize == -1) {
            return;
        }
        bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeBoard = gameManagement.settingBridge(bridge, bridgeSize);
        gameManagement.gameProgress(bridgeBoard, bridgeSize);
    }

    public void makeBridgeSize() {
        bridgeSize = inputView.readBridgeSize();
    }
}
