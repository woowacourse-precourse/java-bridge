package bridge;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MoveBridge {
    private final String moveBridgePhrase;

    public MoveBridge(String moveBridgePhrase) {
        if ((!Objects.equals(moveBridgePhrase, BridgeMaker.UP_BRIDGE_PHRASE)) && (!Objects.equals(moveBridgePhrase, BridgeMaker.DOWN_BRIDGE_PHRASE))) {
            throw new NoSuchElementException();
        }
        this.moveBridgePhrase = moveBridgePhrase;
    }

    public String getMoveBridgePhrase() {
        return moveBridgePhrase;
    }
}
