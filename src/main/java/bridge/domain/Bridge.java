package bridge.domain;

import bridge.constant.MovingResult;
import java.util.List;

public class Bridge {
    private List<String> bridgePosition;

    public Bridge(List<String> bridgePosition) {
        this.bridgePosition = bridgePosition;
    }

    public String compareUserInput(List<String> move) {
        int compareIndex = getCompareIndex(move);
        boolean comparison = move.get(compareIndex).equals(bridgePosition.get(compareIndex));
        return getSign(comparison);
    }

    public String getSign(boolean comparison) {
        return MovingResult.fromComparison(comparison)
                .getSign();
    }

    public boolean compareLength(List<String> user) {
        return bridgePosition.size() == user.size();
    }

    public int getCompareIndex(List<String> move) {
        return move.size() - 1;
    }
}
