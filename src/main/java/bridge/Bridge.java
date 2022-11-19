package bridge;

import java.util.List;

public class Bridge {
    private List<String> bridgePosition;

    public Bridge(List<String> bridgePosition) {
        this.bridgePosition = bridgePosition;
    }

    public boolean compare(List<String> move) {
        return move.get(move.size() - 1).equals(bridgePosition.get(move.size() - 1));
    }
}
