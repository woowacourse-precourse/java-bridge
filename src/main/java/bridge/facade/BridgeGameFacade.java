package bridge.facade;

import bridge.constance.GameConstance;
import bridge.domain.Bridge;
import bridge.domain.BridgeStatus;
import bridge.domain.Player;

import java.util.List;

public class BridgeGameFacade {
    private final Bridge bridge;
    private final Player player;
    private BridgeStatus bridgeStatus;

    public BridgeGameFacade(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        this.bridgeStatus = new BridgeStatus();
    }

    public void initBridge(List<String> bridge) {
        this.bridge.init(bridge);
    }

    public BridgeStatus moveToBlock(int currentPosition, String blockToMove) {
        String blockMark = expressionOfBlock(currentPosition, blockToMove);
        return marking(blockMark, blockToMove);
    }

    public void gameInit() {
        player.init();
        bridgeStatus = new BridgeStatus();
    }

    public BridgeStatus finalGameResult() {
        return this.bridgeStatus;
    }

    private String expressionOfBlock(int currentPosition, String block) {
        if (bridge.canCross(currentPosition, block)) {
            player.move();
            isDoneCrossingBridge(player.getCurrentPosition());
            return GameConstance.CROSSABLE_EXPRESSION;
        }
        player.fail();
        return GameConstance.NOT_CROSSABLE_EXPRESSION;
    }

    private void isDoneCrossingBridge(int currentPosition) {
        if(bridge.isDoneCrossingBridge(currentPosition)) {
            player.success();
        }
    }

    private BridgeStatus marking(String mark, String block) {
        if(block.equals(GameConstance.UP_BLOCK_EXPRESSION)) {
            bridgeStatus.addStatus(mark, GameConstance.EMPTY_BLOCK);
            return bridgeStatus;
        }

        bridgeStatus.addStatus(GameConstance.EMPTY_BLOCK, mark);
        return bridgeStatus;
    }
}
