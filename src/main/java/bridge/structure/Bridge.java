package bridge.structure;


import java.util.List;

public class Bridge {

    private final int TURN_COUNT_MIN = 0;
    private final String WARM = "[ERROR]";
    private final String WARM_OVER_TURN = WARM + " 내부 오류 입니다. 다리 길이보다 많이 시도하였습니다.";

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean canGo(BridgeMoveValue bridgeMoveValue, int turnCount) {
        validateTurnCount(turnCount);
        String bridgeValue = this.bridge.get(turnCount);
        if (bridgeMoveValue.getStringIdentifier()
                .equals(bridgeValue)) {
            return true;
        }
        return false;
    }

    public void validateTurnCount(int turnCount) {
        if (turnCount < TURN_COUNT_MIN || bridge.size() < turnCount) {
            throw new IllegalArgumentException(WARM_OVER_TURN);
        }
    }
}
