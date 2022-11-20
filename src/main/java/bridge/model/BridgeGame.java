package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Player player;
    private Bridge bridge;

    public BridgeGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.player = new Player();
    }

    public void create() {
        int size = player.inputBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void tryGame() {
        player.retry();
    }

    public boolean move() {
        String nextLocation = player.inputMove();
        if (bridge.ableToMove(nextLocation, player.getCurrentIndex() + 1)) {
            player.move();
            return true;
        }
        return false;
    }

    public boolean isOnGoing() {
        if (player.getCurrentIndex() < bridge.getBridgeSize() - 1) {
            return true;
        }
        return false;
    }

    public boolean retry() {
        String command = player.inputCommand();
        if (command.equals(Constants.RESTART)) {
            player.retry();
            return true;
        }
        return false;
    }



}
