package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.utils.message.FixedMessage;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final List<String> bridge = new ArrayList<>();

    public void startGame() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        System.out.println(FixedMessage.GAME_START.getMessage() + "\n");
        bridge.addAll(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }
}
