package bridge.domain.move_result;

import bridge.domain.constants.MoveCommands;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultsPerLine {

    public static final String BLANK = " ";

    private final MoveCommands moveCommands;
    private final List<String> results = new ArrayList<>();

    public ResultsPerLine(final MoveCommands moveCommands) {
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
