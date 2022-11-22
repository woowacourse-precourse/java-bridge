package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        final BridgeGame bridgeGame = new BridgeGame();
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> generatedBridge = bridgeMaker.makeBridge(bridgeGame.readBridgeSizeService());
        List<String> nowBridge = new ArrayList<>();
        // 게임 시작
        int count = bridgeGame.gameManagement(nowBridge, generatedBridge);
        StringBuffer bridgeScreen = bridgeGame.printMapService(nowBridge, generatedBridge);
        System.out.println(bridgeGame.printResultService(count, bridgeScreen, bridgeGame.isGameWin(nowBridge, generatedBridge)));
    }
}