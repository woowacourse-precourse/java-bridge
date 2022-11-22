package bridge.domain;

import static bridge.exception.Validator.validMoving;

import java.util.Objects;

public class Round {

    private final Moving playerMoving;
    private final RoundResult result;

    public Round(String playerMovingExpression, String bridgeMovingExpression) {
        this.playerMoving = validMoving(playerMovingExpression);
        this.result = compare(playerMovingExpression, bridgeMovingExpression);
    }

    public RoundResult compare(String playerMovingExpression, String bridgeMovingExpression) {
        if (Objects.equals(bridgeMovingExpression, playerMovingExpression)) {
            return RoundResult.SUCCESS;
        }
        return RoundResult.FAILURE;
    }

    public String getUpMap() {
        if (Objects.equals(playerMoving, Moving.UP)) {
            return result.getExpression();
        }
        return " ";
    }
    public String getDownMap() {
        if (Objects.equals(playerMoving, Moving.DOWN)) {
            return result.getExpression();
        }
        return " ";
    }

    public RoundResult getResult() {
        return result;
    }
}
