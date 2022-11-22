package bridge.domain;

import bridge.domain.type.MoveResultType;
import bridge.validator.PositionValidator;

import java.util.List;

public class Bridge {
    final List<String> bridge;
    PositionValidator positionValidator;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.positionValidator = new PositionValidator(bridge.size());
    }

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    boolean isEndOfBridge(int position) {
        positionValidator.validatePosition(position);
        return position == bridge.size();
    }

    boolean isMovable(String moveCommand, int position) {
        positionValidator.validatePosition(position);
        return bridge.get(position).equals(moveCommand);
    }

    MoveResultType getMoveResult(String moveCommand, int position) {
        positionValidator.validatePosition(position);
        if (isMovable(moveCommand, position)) {
            return MoveResultType.SUCCESS;
        }
        return MoveResultType.FAIL;
    }
}
