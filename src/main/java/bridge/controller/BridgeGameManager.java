package bridge.controller;

import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import java.util.List;

public class BridgeGameManager {
    private InputView inputView = new InputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void play() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        makeBridge();
        crossBridge();
        printGameResult();
    }

    private void makeBridge() {
        try {
            int readBridgeSize = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(readBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeBridge();
        }
    }

    private void crossBridge() {

    }

    private void printGameResult() {

    }
}