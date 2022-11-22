package bridge.service;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.Player;
import bridge.util.BridgeGameStatus;

import java.util.List;
import java.util.StringJoiner;

public class BridgeService {
    private static final StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
    private final BridgeMaker bridgeMaker;


    public BridgeService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }
    public Bridge makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(size, bridge);
    }

    public boolean move(Bridge bridge, Player player) {
        String currentMove = player.getCurrentMove();
        String bridgeData = bridge.getBridge().get(player.getCurrentLocation());

        boolean canMove = isSame(currentMove, bridgeData);
        player.addPlayerMove(getCanShape(canMove));

        return canMove;
    }

    public boolean isSame(String currentMove, String brdigeData) {
        return brdigeData.equals(currentMove);
    }

    public String getCanShape(boolean canMove) {
        if (canMove) {
            return BridgeGameStatus.CORRECT.getGameStatus();
        }

        return BridgeGameStatus.INCORRECT.getGameStatus();
    }
}
