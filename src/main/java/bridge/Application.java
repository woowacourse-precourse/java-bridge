package bridge;

import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.service.BridgeGame.*;
import static bridge.controller.BridgeController.readBridgeSizeController;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size = readBridgeSizeController();
        List<String> nowBridge = new ArrayList<>();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridge = bridgeMaker.makeBridge(size);
        int count = gameManagement(nowBridge, generatedBridge);
        OutputView.printResult(count, nowBridge, generatedBridge);
    }


}