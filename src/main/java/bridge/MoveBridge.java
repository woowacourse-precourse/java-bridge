package bridge;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MoveBridge {
    private static final String MOVE_BRIDGE_EXCEPTION_MESSAGE = "[ERROR] 위는 U, 아래는 D로 입력해야 합니다.";
    private final String moveBridgePhrase;

    public MoveBridge(String moveBridgePhrase) {
        if ((!Objects.equals(moveBridgePhrase, BridgeMaker.UP_BRIDGE_PHRASE)) && (!Objects.equals(moveBridgePhrase, BridgeMaker.DOWN_BRIDGE_PHRASE))) {
            throw new NoSuchElementException(MOVE_BRIDGE_EXCEPTION_MESSAGE);
        }
        this.moveBridgePhrase = moveBridgePhrase;
    }

    public String getMoveBridgePhrase() {
        return moveBridgePhrase;
    }
}
