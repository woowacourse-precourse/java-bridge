package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.domain.bridgeTool.BridgeMaker;
import bridge.domain.bridgeTool.BridgeNumberGenerator;
import bridge.domain.bridgeTool.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.BridgeUtil.BINARY_UP;

public class BridgeGame {

    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker;
    private Bridge bridge;
    private Player player;
    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();
    private int tryCount = initTryCount();
    private boolean crossAllBridge;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    private int initTryCount() {
        return BINARY_UP;
    }

    public void initBridge(int bridgeSize) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void initPlayer() {
        this.player = new Player();
    }

    private void initBridgeMap() {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }
}
