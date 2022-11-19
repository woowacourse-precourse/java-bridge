package bridge.domain;

import bridge.ui.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PlayerBoard {
    private static final String BLANK = " ";
    private static final String UP = "U";
    private static final String DOWN = "D";

    private int gameRound;
    private List<String> upBridge;
    private List<String> downBridge;

    public PlayerBoard() {
        gameRound = 0;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }


    public int getGameRound() {
        return gameRound;
    }

    public void addResultOfBridge(String targetSide, String roundResult) {
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


}
