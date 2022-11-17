package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class BridgeController {
    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> list = bridgeMaker.makeBridge(size);
        System.out.println(list);
    }
}
