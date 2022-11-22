package bridge.domain;

import java.util.Objects;

import static bridge.utils.ErrorMessage.*;

public class GameReferee {
    private final Bridge bridge;

    public GameReferee(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrectMoving(PlayerMoving playerMoving, int bridgeIndex) {
        try {
            return (Objects.equals(bridge.getBridgeOfIndex(bridgeIndex), playerMoving.getMoving()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(INDEX_OUT_OF_BOUNDS);
            return false;
        }
    }
}