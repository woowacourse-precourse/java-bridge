package bridge.command;

public enum MoveCommand {
    MoveUp("U"),
    MoveDown("D");

    private final String moveDirection;

    MoveCommand(String moveDirection) {
        this.moveDirection = moveDirection;
    }

    public String getMoveDirection() {
        return moveDirection;
    }
}
