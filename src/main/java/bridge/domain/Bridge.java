package bridge.domain;

import bridge.validator.PositionValidator;

import java.util.List;

public class Bridge {
    final List<String> bridge;
    PositionValidator positionValidator;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.positionValidator = new PositionValidator(bridge.size());
    }

    public static Bridge from(List<String> bridge){
        return new Bridge(bridge);
    }

    boolean isEndOfBridge(int position) {
        positionValidator.validatePosition(position);
        if (position == bridge.size()) {
            return true;
        }
        return false;
    }

    boolean isMovable(String moveCommand, int position) {
        positionValidator.validatePosition(position);
        if (bridge.get(position).equals(moveCommand)) {
            return true;
        }
        return false;
    }

    MoveResult getMoveResult(String moveCommand, int position) {
        positionValidator.validatePosition(position);
        if (isMovable(moveCommand, position)) {
            return MoveResult.SUCCESS;
        }
        return MoveResult.FAIL;
    }
}
