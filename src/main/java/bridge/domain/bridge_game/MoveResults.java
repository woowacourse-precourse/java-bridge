package bridge.domain.bridge_game;

import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;

import bridge.domain.constants.MoveCommands;
import java.util.List;

public class MoveResults {

    private final MoveResultsPerLine upLineResults = new MoveResultsPerLine(MOVE_UP_COMMAND);
    private final MoveResultsPerLine downLineResults = new MoveResultsPerLine(MOVE_DOWN_COMMAND);

    public void addResults(final MoveCommands moveCommand, final String moveResult) {
        upLineResults.addMoveResults(moveCommand, moveResult);
        downLineResults.addMoveResults(moveCommand, moveResult);
    }

    void reset() {
        upLineResults.clear();
        downLineResults.clear();
    }

    public List<String> upLineResults() {
        return upLineResults.results();
    }

    public List<String> downLineResults() {
        return downLineResults.results();
    }
}
