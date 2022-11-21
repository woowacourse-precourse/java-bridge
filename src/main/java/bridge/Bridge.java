package bridge;

import java.util.List;

public class Bridge {
    private List<String> bridgePosition;

    public Bridge(List<String> bridgePosition) {
        this.bridgePosition = bridgePosition;
    }

    public String compare(List<String> move) {
//        return move.get(move.size() - 1).equals(bridgePosition.get(move.size() - 1));
        boolean comparison = move.get(move.size() - 1).equals(bridgePosition.get(move.size() - 1));
        return getSign(comparison);
    }

    public String getSign(boolean comparison) {
        return MovingResult.fromComparison(comparison)
                .getSign();
    }

    public boolean compareLength(List<String> user) {
        return bridgePosition.size() == user.size();
    }
}
