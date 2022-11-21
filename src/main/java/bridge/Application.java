package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        final BridgeGame bridgeGame = new BridgeGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        // 사이즈 길이만큼 다리 생성
        List<String> generatedBridge = bridgeMaker.makeBridge(bridgeGame.readBridgeSizeService());
        List<String> nowBridge = new ArrayList<>();
        // 게임 시작
        int count = bridgeGame.gameManagement(nowBridge, generatedBridge);
        // 결과 출력
        bridgeGame.printResultService(count, nowBridge, generatedBridge);
    }
}