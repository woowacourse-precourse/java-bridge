package bridge.domain;

public enum BridgeMove {
    UP(1, "U"), DOWN(0, "D");

    private final String moveCommand;
    private final int moveCode;

    BridgeMove(int moveCode, String moveCommand) {
        this.moveCode = moveCode;
        this.moveCommand = moveCommand;
    }

    public String getMoveCommand() {
        return this.moveCommand;
    }

    public int getMoveCode() {
        return this.moveCode;
    }

    public static BridgeMove getBridgeMoveByMoveCommand(String moveCommand) {
        for (BridgeMove move : BridgeMove.values()) {
            if (move.moveCommand.equals(moveCommand)) {
                return move;
            }
        }
        throw new IllegalArgumentException("U 또는 D를 입력해주세요.");

    }

    public static BridgeMove getBridgeMoveByMoveCode(int moveCode) {
        for (BridgeMove move : BridgeMove.values()) {
            if (move.moveCode == (moveCode)) {
                return move;
            }
        }
        throw new IllegalArgumentException("0 또는 1를 입력해주세요.");

    }
}
