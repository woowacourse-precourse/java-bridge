package bridge.service;

import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.domain.Player;

public class BridgeServiceImpl implements BridgeService{
    private final BridgeMaker bridgeMaker;

    public BridgeServiceImpl(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    @Override
    public Bridge buildBridge(int size) {
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    @Override
    public int makeStep(Player player, String step) {
        return player.move(step);
    }

    @Override
    public Player createPlayer(Bridge bridge) {
        return new Player(bridge);
    }

    @Override
    public boolean checkMovable(Player player) {
        return player.movable();
    }

    @Override
    public boolean checkSuccess(Player player) {
        return player.isSuccess();
    }

    @Override
    public void startNewRound(Player player) {
        player.startRound();
    }
}
