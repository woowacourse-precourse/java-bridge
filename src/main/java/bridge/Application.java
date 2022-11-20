package bridge;

import bridge.controller.BridgeController;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.service.BridgeGame.*;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size = bridgeController.readBridgeSizeController();
        List<String> nowBridge = new ArrayList<>();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridge = bridgeMaker.makeBridge(size);
        int count = bridgeController.gameManagementController(nowBridge, generatedBridge);
        bridgeController.printResultController(count, nowBridge, generatedBridge);
    }
}