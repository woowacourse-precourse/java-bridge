package bridge.option;

import static bridge.option.Option.validate;

public class Move {

    private final String move;

    public Move(String move) {
        validate(move);
        this.move = move;
    }
}
