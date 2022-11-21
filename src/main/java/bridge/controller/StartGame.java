package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.PrintSentence;

import java.util.List;

public class StartGame {
    private static InputView input = new InputView();
    public BridgeGame setBridgeSize() {
        System.out.println(PrintSentence.START.getSentence());
        int length = input.readBridgeSize();
        return new BridgeGame(makeBridge(length));
    }

    private List<String> makeBridge(int length) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = maker.makeBridge(length);
        return bridge;
    }
}
