package bridge.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BridgeGameStatus {
    
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
}
