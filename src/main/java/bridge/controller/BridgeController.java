package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.object.Bridge;
import bridge.domain.object.Player;
import bridge.input.InputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, BridgeMaker bridgemaker) {
        this.inputView = inputView;
        this.bridgeMaker = bridgemaker;
    }

    public void start() {
        BridgeGame game = init();
    }

    public void end() {

    }

    private BridgeGame init() {
        Player player = initPlayer();
        Bridge bridge = initBridge();
        return new BridgeGame(player, bridge);
    }

    private Player initPlayer() {
        return new Player();
    }

    private Bridge initBridge() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridge);
    }
}
