package bridge.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeGame {
    public static String SUCCESS = "성공";
    public static String FAILURE = "실패";
    public static String MOVING = "이동";
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

    public List<List<String>> makeBridgeCrossingResult(){
        List<List<String>> maps = new ArrayList<>();
        /*List<String> bridgeClass = bridge.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < bridgeClass.size(); i++){
            maps.add(makeBridgeCrossingResultEntry(bridgeClass.get(i)));
        }*/
        maps.add(makeBridgeCrossingResultEntry("U"));
        maps.add(makeBridgeCrossingResultEntry("D"));
        return maps;
    }

    public List<String> makeBridgeCrossingResultEntry(String position){
        List<String> map = new ArrayList<>();
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
            return SUCCESS;
        } else if (bridgeCrossingResult.get(bridgeCrossingResult.size()-1).equals("O") && bridgeCrossingResult.size() != bridge.size()) {
            return MOVING;
        }
        return FAILURE;
    }

    @Override
    public String toString(){
        return String.valueOf(retryCount);
    }
}