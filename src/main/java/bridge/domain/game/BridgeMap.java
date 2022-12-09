package bridge.domain.game;

import bridge.constant.Game;
import bridge.constant.Message;
import bridge.constant.enums.Moving;
import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final List<List<String>> bridgeMap;

    public BridgeMap() {
        bridgeMap = new ArrayList<List<String>>(
                List.of(new ArrayList<String>(),
                        new ArrayList<String>()));
    }

    @Override
    public String toString() {
        final StringBuilder format = new StringBuilder();
        for (final List<String> side : bridgeMap) {
            format.append(Message.START_BRACKET)
                    .append(String.join(Message.VERTICAL_BAR, side))
                            .append(Message.END_BRACKET)
                                    .append(Message.NEW_LINE);
        }
        return format.toString();
    }

    public void update(final String direction, final boolean gameOver) {
        if (gameOver) {
            markFailedMove(direction);
            return;
        }
        markSuccessfulMove(direction);
    }

    void clear() {
        bridgeMap.get(Game.MapConstants.UP_SIDE_INDEX).clear();
        bridgeMap.get(Game.MapConstants.DOWN_SIDE_INDEX).clear();
    }

    private void markFailedMove(final String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            bridgeMap.get(Game.MapConstants.UP_SIDE_INDEX).add(Game.MapConstants.FAILED_MOVE_MARK);
            bridgeMap.get(Game.MapConstants.DOWN_SIDE_INDEX).add(Game.MapConstants.NEVER_STEPPED_MARK);
            return;
        }
        bridgeMap.get(Game.MapConstants.UP_SIDE_INDEX).add(Game.MapConstants.NEVER_STEPPED_MARK);
        bridgeMap.get(Game.MapConstants.DOWN_SIDE_INDEX).add(Game.MapConstants.FAILED_MOVE_MARK);
    }

    private void markSuccessfulMove(final String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            bridgeMap.get(Game.MapConstants.UP_SIDE_INDEX).add(Game.MapConstants.SUCCESSFUL_MOVE_FORMAT);
            bridgeMap.get(Game.MapConstants.DOWN_SIDE_INDEX).add(Game.MapConstants.NEVER_STEPPED_MARK);
            return;
        }
        bridgeMap.get(Game.MapConstants.UP_SIDE_INDEX).add(Game.MapConstants.NEVER_STEPPED_MARK);
        bridgeMap.get(Game.MapConstants.DOWN_SIDE_INDEX).add(Game.MapConstants.SUCCESSFUL_MOVE_FORMAT);
    }
}
