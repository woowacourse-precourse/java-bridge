package bridge.domain;

import bridge.constant.MoveCommand;

import java.util.*;

public class BridgeGameResultLine {
    public static final String BLANK = " ";

    private final MoveCommand moveCommands;
    private final List<String> results = new ArrayList<>();

    public BridgeGameResultLine(MoveCommand moveCommands) {
        this.moveCommands = moveCommands;
    }

    void addMoveResults(MoveCommand moveCommands, String moveResult) {
        if (this.moveCommands == moveCommands) {
            results.add(moveResult);
            return;
        }
        results.add(BLANK);
    }

    List<String> results() {
        return Collections.unmodifiableList(results);
    }

    void clear() {
        results.clear();
    }

}
