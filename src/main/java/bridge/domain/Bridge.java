package bridge.domain;

import bridge.domain.validation.BridgeValidation;
import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final Integer START_SUBLIST = 0;
    private final List<String> squares;

    public Bridge(List<String> squares) {
        validate(squares);
        this.squares = squares;
    }

    public List<String> getSquares() {
        return squares;
    }

    public boolean isPassableBridge(Bridge otherBridge) {
        List<String> otherBridgeSquares = otherBridge.squares;
        List<String> partialSquares= new ArrayList<>(squares.subList(START_SUBLIST, otherBridgeSquares.size()));
        return partialSquares.equals(otherBridgeSquares);
    }

    private void validate(List<String> squares) {
        BridgeValidation.validate(squares);
    }
}
