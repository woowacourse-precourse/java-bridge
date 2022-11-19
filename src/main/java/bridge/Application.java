package bridge;

import bridge.service.BridgeMaker;
import bridge.service.PlayerSetting;
import bridge.view.InputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final PlayerSetting playerSetting = new PlayerSetting();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }

    private static void startGame() {
        setPlayer();
    }

    private static void setPlayer() {
        String bridgeLength = inputView.readBridgeSize();
        playerSetting.setBridgeSizeToPlayer(bridgeLength);
    }
}
