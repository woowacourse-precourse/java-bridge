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
        validateOverRange(bridgeMoveTypes);
        int currentLocation = playerBridge.size() - 1;
        BridgeMoveType playerMoveType = playerBridge.get(currentLocation);
        BridgeMoveType bridgeMoveType = bridgeMoveTypes.get(currentLocation);
        return playerMoveType != bridgeMoveType;
    }

    public boolean isAllMoveTypeSameAs(List<BridgeMoveType> bridgeMoveTypes) {
        validateBridgeSize(playerBridge);
        validateBridgeSize(bridgeMoveTypes);
        validateOverRange(bridgeMoveTypes);
        if (isNotSameBridgeSizeWith(bridgeMoveTypes)) {
            return false;
        }
        return compareAllMoveTypesSame(bridgeMoveTypes);
    }

    public boolean isNotSameBridgeSizeWith(List<BridgeMoveType> bridgeMoveTypes) {
        return playerBridge.size() != bridgeMoveTypes.size();
    }

    private boolean compareAllMoveTypesSame(List<BridgeMoveType> bridgeMoveTypes) {
        return IntStream.range(0, playerBridge.size())
                .filter(currentLocation -> {
                    BridgeMoveType playerMoveType = playerBridge.get(currentLocation);
                    BridgeMoveType answerMoveType = bridgeMoveTypes.get(currentLocation);
                    return playerMoveType.isSame(answerMoveType);
                }).count() == playerBridge.size();
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
        if (bridgeMoveTypes.isEmpty()) {
            throw new IllegalArgumentException(BRIDGE_SIZE_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateOverRange(List<BridgeMoveType> bridgeMoveTypes) {
        if (playerBridge.size() > bridgeMoveTypes.size()) {
            throw new IllegalStateException(PLAYER_BRIDGE_SIZE_OVER_RANGE_EXCEPTION.getMessage());
        }
    }
}
