package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PlayerBoard {
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]\n";
    private static final String DELIMITER = " | ";
    private static final String BLANK = " ";
    private static final String UP = "U";
    private static final String DOWN = "D";

    private final int endRound;

    private int gameRound;
    private List<String> upBridge;
    private List<String> downBridge;

    PlayerBoard(final int BRIDGE_SIZE) {
        gameRound = 0;
        endRound = BRIDGE_SIZE;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    boolean isOver() {
        return gameRound == endRound;
    }

    int getGameRound() {
        return gameRound;
    }

    void addResultOfBridge(String targetSide, String roundResult) {
        if (targetSide.equals(UP)) {
            upBridge.add(gameRound, roundResult);
            downBridge.add(gameRound, BLANK);
        }
        if (targetSide.equals(DOWN)) {
            downBridge.add(gameRound, roundResult);
            upBridge.add(gameRound, BLANK);
        }
        gameRound++;
    }

    String getBridgeStatus(String side) {
        StringJoiner joiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (int i = 0; i < gameRound; i++) {
            if (side.equals(UP)) {
                joiner.add(upBridge.get(i));
            }
            if (side.equals(DOWN)) {
                joiner.add(downBridge.get(i));
            }
        }
        return joiner.toString();
    }
}
