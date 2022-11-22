package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    public static final String O = " O ";
    public static final String X = " X ";
    public static final String EMPTY = "   ";
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";
    public static final String DELIMITER = "|";

    private final List<String> upSide;
    private final List<String> downSide;


    public BridgeMap() {
        this.upSide = new ArrayList<>();
        this.downSide = new ArrayList<>();
    }

    public void correctMove(Move move) {
        if (move == Move.UP) {
            upSide.add(O);
            downSide.add(EMPTY);
        }
        if (move == Move.DOWN) {
            upSide.add(EMPTY);
            downSide.add(O);
        }
    }

    public void wrongMove(Move move) {
        if (move == Move.UP) {
            upSide.add(X);
            downSide.add(EMPTY);
        }
        if (move == Move.DOWN) {
            upSide.add(EMPTY);
            downSide.add(X);
        }
    }

    public void move(Move move, boolean isCorrect) {
        if (isCorrect) {
            correctMove(move);
            return;
        }
        wrongMove(move);
    }

    public String getUpSide() {
        return PREFIX + String.join(DELIMITER, upSide) + SUFFIX;
    }

    public String getDownSide() {
        return PREFIX + String.join(DELIMITER, downSide) + SUFFIX;
    }

    @Override
    public String toString() {
        return getUpSide() + "\n" + getDownSide() + "\n";
    }

    public void clear() {
        upSide.clear();
        downSide.clear();
    }
}
