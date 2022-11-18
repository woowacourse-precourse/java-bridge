package bridge;

public class User {

    private final MoveResult moveResult;

    public User() {
        moveResult = new MoveResult();
    }

    public void addResult(int status, String moveCommand) {
        moveResult.add(status, moveCommand);
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
