package bridge.domain.move_result;

import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;

import bridge.domain.constants.MoveCommands;
import java.util.List;

public class MoveResults {

    private final ResultsPerLine upLineResults = new ResultsPerLine(MOVE_UP_COMMAND);
    private final ResultsPerLine downLineResults = new ResultsPerLine(MOVE_DOWN_COMMAND);

    public void addResults(MoveCommands moveCommand, String moveResult) {
        upLineResults.addMoveResults(moveCommand, moveResult);
        downLineResults.addMoveResults(moveCommand, moveResult);
    }

    public void reset() {
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
