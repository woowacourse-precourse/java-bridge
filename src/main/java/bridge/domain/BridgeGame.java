package bridge.domain;

import java.util.*;
import java.util.stream.Stream;

import static bridge.domain.BridgeEnum.*;

public class BridgeGame {
    private final List<String> bridge;
    private final List<String> bridgeCrossingResult = new ArrayList<>();
    private int retryCount = 1;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public List<String> move(String userInput) {
        if (bridge.get(bridgeCrossingResult.size()).equals(userInput)){
            bridgeCrossingResult.add(MOVE_SUCCESS.getValue());
            return bridgeCrossingResult;
        }
        bridgeCrossingResult.add(MOVE_FAILURE.getValue());
        return bridgeCrossingResult;
    }

    public void retry() {
        bridgeCrossingResult.clear();
        retryCount += 1;
    }

    public List<List<String>> makeBridgeCrossingResult(){
        List<List<String>> maps = new ArrayList<>();
        Stream.of(BridgePair.values()).map(BridgePair::getValue)
                .forEach(m -> {
                    List<String> map = new ArrayList<>();
                    maps.add(BridgePair.findPair(m).getListIndex(),makeBridgeCrossingResultEntry(m, map));
                });
        return maps;
    }

    public List<String> makeBridgeCrossingResultEntry(String position, List<String> map){
        for (int i = 0; i < bridgeCrossingResult.size(); i++){
            if (bridge.get(i).equals(position)){
                map.add(bridgeCrossingResult.get(i));
                continue;
            }
            map.add(" ");
        }
        return map;
    }

    public String judgment(){
        if (bridgeCrossingResult.get(bridgeCrossingResult.size()-1).equals("O") && bridgeCrossingResult.size() == bridge.size()){
            return SUCCESS.getValue();
        } else if (bridgeCrossingResult.get(bridgeCrossingResult.size()-1).equals("O") && bridgeCrossingResult.size() != bridge.size()) {
            return MOVING.getValue();
        }
        return FAILURE.getValue();
    }

    @Override
    public String toString(){
        return String.valueOf(retryCount);
    }
}