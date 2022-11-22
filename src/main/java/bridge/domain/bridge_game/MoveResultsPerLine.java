package bridge.domain.bridge_game;

import bridge.domain.constants.MoveCommands;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoveResultsPerLine {

    public static final String BLANK = " ";

    private final MoveCommands moveCommands;
    private final List<String> results = new ArrayList<>();

    public MoveResultsPerLine(final MoveCommands moveCommands) {
        this.moveCommands = moveCommands;
    }

    void addMoveResults(final MoveCommands moveCommands, final String moveResult) {
        if (this.moveCommands.is(moveCommands)) {
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
