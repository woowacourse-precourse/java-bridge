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

    public RoundResult getResult() {
        return result;
    }

    public Moving getPlayerMoving() {
        return playerMoving;
    }
}
