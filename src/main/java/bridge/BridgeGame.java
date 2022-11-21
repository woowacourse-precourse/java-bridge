package bridge;

public class BridgeGame {
    private StringBuilder firstRoad = new StringBuilder();
    private StringBuilder secondRoad = new StringBuilder();
    private int roundCount = 1;
    private final String O = "O";
    private final String X = "X";
    private final String SPACE = " ";

    public StringBuilder getFirstRoad() {
        return firstRoad;
    }

    public StringBuilder getSecondRoad() {
        return secondRoad;
    }

    public int getRoundCount() {
        return roundCount;
    }

}
