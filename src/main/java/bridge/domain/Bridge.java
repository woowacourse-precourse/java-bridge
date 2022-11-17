package bridge.domain;

import bridge.bridgemaker.PlayerMove;
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

    private void validate(List<String> squares) {
        BridgeValidation.validate(squares);
    }

    public boolean checkBridge(Bridge otherBridge) {
        List<String> otherBridgeSquares = otherBridge.squares;
        List<String> partialSquares= new ArrayList<>(squares.subList(START_SUBLIST, otherBridgeSquares.size()));
        return partialSquares.equals(otherBridgeSquares);
    }
}
