package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final Integer START_SUBLIST = 0;
    private final List<String> squares;

    public Bridge(List<String> squares) {
        validate();
        this.squares = squares;
    }

    private void validate() {}

    public boolean checkBridge(Bridge otherBridge) {
        List<String> otherBridgeSquares = otherBridge.squares;
        List<String> partialSquares= new ArrayList<>(squares.subList(START_SUBLIST, otherBridgeSquares.size()));
        return partialSquares.equals(otherBridgeSquares);
    }
}
