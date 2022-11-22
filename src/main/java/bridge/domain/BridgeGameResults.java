package bridge.domain;

import bridge.constant.MoveCommand;

import java.util.List;

import static bridge.constant.MoveCommand.MOVE_DOWN_VALUE;
import static bridge.constant.MoveCommand.MOVE_UP_VALUE;

public class BridgeGameResults {

    private final BridgeGameResultLine upLineResults = new BridgeGameResultLine(MOVE_UP_VALUE);
    private final BridgeGameResultLine downLineResults = new BridgeGameResultLine(MOVE_DOWN_VALUE);

    public void addResults(final MoveCommand moveCommand, final String moveResult) {
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
