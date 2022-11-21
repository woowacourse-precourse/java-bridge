package bridge;

import java.util.List;

public class Controller {

    public void start() {
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();

        //다리 생성 실패시
        if (bridgeSize == -1) {
            return;
        }
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge;
        bridge = bridgeMaker.makeBridge(bridgeSize);
        String[][] bridgeBoard;
        GameManagement gameManagement = new GameManagement();
        bridgeBoard = gameManagement.settingBridge(bridge, bridgeSize);
        gameManagement.gameProgress(bridgeBoard, bridgeSize);
    }
}
