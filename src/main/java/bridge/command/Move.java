package bridge.command;

import static bridge.config.ExceptionMessage.WRONG_MOVE_OPTION;

import bridge.command.enums.PlayerMove;

public class Move {

    private final String move;

    public Move(String move) {
        Option.validate(move);
        validate(move);
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public static void validateMoveAvailable(String move) {
        if (!PlayerMove.isInPlayerMove(move)) {
            throw new IllegalArgumentException(WRONG_MOVE_OPTION.toString());
        }
    }

    private static void validate(String move) {
        validateMoveAvailable(move);
    }
}
