package bridge.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeGameStatus {

    private final static String MOVE_MARKER = "O";
    private final static String WRONG_MOVE_MARKER = "X";
    private final static String NO_MOVE_MARKER = " ";
    private final static String MARKER_DELIMETER = " | ";
    private final static String OPEN_LINE = "[ ";
    private final static String CLOSE_LINE = " ]";
    
    private final List<String> playerMove;
    private final List<String> gameBridge;
    private final int runCount;

    public BridgeGameStatus(List<String> playerMove, List<String> gameBridge, int runCount) {
        this.playerMove = playerMove;
        this.gameBridge = gameBridge;
        this.runCount = runCount;
    }

    public int getRunCount() {
        return runCount;
    }

    public boolean isGameSuccessfulEnd() {
        if (playerMove.size() != gameBridge.size()) {
            return false;
        }
        return IntStream.range(0, playerMove.size())
                .filter(idx -> Objects.equals(playerMove.get(idx), gameBridge.get(idx)))
                .count() == gameBridge.size();
    }

    @Override
    public String toString() {
        final String upLine = createStatusLine(Moving.UP);
        final String downLine = createStatusLine(Moving.DOWN);
        return upLine + "\n" + downLine;
    }

    private String createStatusLine(Moving moving) {
        return OPEN_LINE + IntStream.range(0, playerMove.size())
                .mapToObj(idx -> directionToMarker(playerMove.get(idx), gameBridge.get(idx), moving))
                .collect(Collectors.joining(MARKER_DELIMETER)) + CLOSE_LINE;
    }

    private String directionToMarker(String player, String bridge, Moving moving) {
        if (Objects.equals(player, moving.getDirection())) {
            if (!Objects.equals(player, bridge)) return WRONG_MOVE_MARKER;
            return MOVE_MARKER;
        }
        return NO_MOVE_MARKER;
    }
}
