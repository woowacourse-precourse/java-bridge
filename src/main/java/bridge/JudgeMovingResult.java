package bridge;

public class JudgeMovingResult {

    private final String POSSIBLE = "O";
    private final String IMPOSSIBLE = "X";

    public String isMovingPossible(String moving, String bridgeDirection) {
        if (moving.equals(bridgeDirection)) {
            return POSSIBLE;
        }
        return IMPOSSIBLE;
    }
}
