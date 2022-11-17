package bridge.domain;

import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {

    private static final String BLANK = " ";

    private final List<String> upResults = new ArrayList<>();
    private final List<String> downResults = new ArrayList<>();

    public void addResults(String moveCommand, String resultSign) {
        if (moveCommand.equals(MOVE_UP_COMMAND)) {
            upResults.add(resultSign);
            downResults.add(BLANK);
            return;
        }

        upResults.add(BLANK);
        downResults.add(resultSign);
    }

    public void reset() {
        upResults.clear();
        downResults.clear();
    }

    public List<String> upResults() {
        return Collections.unmodifiableList(upResults);
    }

    public List<String> downResults() {
        return Collections.unmodifiableList(downResults);
    }
}
