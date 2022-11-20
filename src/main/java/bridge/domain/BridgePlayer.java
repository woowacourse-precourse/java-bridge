package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static bridge.exception.BridgePlayerExceptionMessage.*;

public class BridgePlayer {

    private final List<BridgeMoveType> playerBridge;

    public BridgePlayer() {
        this.playerBridge = new ArrayList<>();
    }

    public boolean isLastMoveTypeNotSameAs(List<BridgeMoveType> bridgeMoveTypes) {
        validateBridgeSize(playerBridge);
        validateBridgeSize(bridgeMoveTypes);
        int currentLocation = playerBridge.size() - 1;
        return playerBridge.get(currentLocation) != bridgeMoveTypes.get(currentLocation);
    }

    public boolean isAllMoveTypeSameAs(List<BridgeMoveType> bridgeMoveTypes) {
        if (playerBridge.size() != bridgeMoveTypes.size()) {
            return false;
        }
        return IntStream.range(0, playerBridge.size())
                .allMatch(currentLocation -> {
                    BridgeMoveType playerMoveType = playerBridge.get(currentLocation);
                    BridgeMoveType answerMoveType = bridgeMoveTypes.get(currentLocation);
                    return playerMoveType.isSame(answerMoveType);
                });
    }

    public void moveTo(BridgeMoveType moveType) {
        playerBridge.add(moveType);
    }

    public void clearPlayerBridge() {
        playerBridge.clear();
    }

    public List<BridgeMoveType> getMoveHistory() {
        return new ArrayList<>(playerBridge);
    }

    private void validateBridgeSize(List<BridgeMoveType> bridgeMoveTypes) {
        if (bridgeMoveTypes.size() == 0) {
            throw new IllegalArgumentException(BRIDGE_SIZE_SIZE_EXCEPTION.getMessage());
        }
    }
}
