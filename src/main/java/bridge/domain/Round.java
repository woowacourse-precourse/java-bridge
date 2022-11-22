package bridge.domain;

import bridge.exception.Validator;
import java.util.Objects;

public class Round {

    private final String playerMoving;
    private RoundResult result;

    public Round(String playerMoving, String bridgeMoving) {
        Validator.validMoving(playerMoving);
        this.playerMoving = playerMoving;
        this.result = compare(bridgeMoving);
    }

    public String getPlayerMoving() {
        return playerMoving;
    }

    public RoundResult getResult() {
        return result;
    }

    public RoundResult compare(String bridgeMoving) {
        if (Objects.equals(bridgeMoving, playerMoving)) {
            return RoundResult.SUCCESS;
        }
        return RoundResult.FAILURE;
    }
}
