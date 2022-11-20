package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private final List<String> bridgeCrossingResult = new ArrayList<>();
    private int retryCount = 1;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public List<String> move(String userInput) {
        if (bridge.get(bridgeCrossingResult.size()).equals(userInput)){
            bridgeCrossingResult.add("O");
            return bridgeCrossingResult;
        }
        bridgeCrossingResult.add("X");
        return bridgeCrossingResult;
    }

    public void retry() {
        bridgeCrossingResult.clear();
        retryCount += 1;
    }

    @Override
    public String toString(){
        return String.valueOf(retryCount);
    }
}