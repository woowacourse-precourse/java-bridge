package bridge.service;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeCell;

import java.util.List;

public class DefaultBridgeGameService implements BridgeGameService {

    private BridgeGame game;

    @Override
    public Bridge createBridge(int bridgeSize, BridgeNumberGenerator generator) {
        BridgeMaker maker = new BridgeMaker(generator);
        List<String> madeBridge = maker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(madeBridge);
        registerBridge(bridge);
        return bridge;
    }

    private void registerBridge(Bridge bridge) {
        this.game = new BridgeGame(bridge);
    }

    @Override
    public boolean moveBridge(BridgeCell cell) {
        return game.move(cell);
    }

    @Override
    public String createMap() {
        return game.getMap();
    }

    @Override
    public boolean retryGame() {
        return game.retry();
    }

    @Override
    public boolean checkGameProgress() {
        return game.isEnd();
    }

    @Override
    public String createResult() {
        return game.getResult();
    }
}
