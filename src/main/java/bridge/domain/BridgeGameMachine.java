package bridge.domain;

import bridge.domain.vo.Moving;

import java.util.Objects;

public class BridgeGameMachine {
    public BridgeGameResult computeGameResult(Moving moving, String bridgeRoom) {
        boolean isMatched = compare(moving.getMoving(), bridgeRoom);
        return new BridgeGameResult(isMatched, moving.getMoving());
    }

    private boolean compare(String moving, String bridgeRoom) {
        return Objects.equals(moving, bridgeRoom);
    }
}
