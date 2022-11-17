package bridge.model;

public class GameResult {
    private final MovementResultManager movementResultManager;
    private boolean canMove;
    private int tryCount;

    private GameResult() {
        movementResultManager = new MovementResultManager();
        canMove = true;
        tryCount = 1;
    }

    public static GameResult getInstance() {
        return new GameResult();
    }

    public String updateMoveResult(String moveSpace, boolean canMove) {
        movementResultManager.setResult(moveSpace, canMove);
        this.canMove = canMove;
        return movementResultManager.toString();
    }

    public boolean canNotGo() {
        return !canMove;
    }

    public void reset() {
        movementResultManager.reset();
        canMove = true;
        tryCount++;
    }

    @Override
    public String toString() {
        return "게임 성공 여부: " +
                convertToResultValue(canMove) +
                "\n총 시도한 횟수: " +
                tryCount;
    }

    private String convertToResultValue(boolean canMove) {
        if (canMove) {
            return "성공";
        }
        return "실패";
    }
}
