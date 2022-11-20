package bridge.game.bridgeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeGameResults {

    private final List<BridgeGameResult> bridgeResults;

    public BridgeGameResults() {
        this.bridgeResults = new ArrayList<>();
    }

    public void add(BridgeGameResult bridgeGameResult) {
        bridgeResults.add(bridgeGameResult);
    }

}
