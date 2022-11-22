package bridge.domain;

import bridge.utils.constants.BridgeRoute;
import bridge.utils.constants.BridgeShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BridgeMap {
    private final List<String> upperAnswerLine = new ArrayList<>();
    private final List<String> lowerAnswerLine = new ArrayList<>();
    private List<String> currentUpperLine =  new ArrayList<>();
    private List<String> currentLowerLine = new ArrayList<>();

    public BridgeMap(Bridge bridge){
        makeBridgeMap(bridge);
    }

    private void makeBridgeMap(Bridge bridge){
        lineMaker(BridgeRoute.UP.getRouth(), bridge, upperAnswerLine);
        lineMaker(BridgeRoute.DOWN.getRouth(), bridge, lowerAnswerLine);
    }

    private void lineMaker(String line, Bridge bridge, List<String> lineMap){
        for(int i = 0; i<bridge.getBridgeSize(); i++){
            lineMap.add(getCorrectMarker(i, line, bridge));
        }
    }

    private String getCorrectMarker(int index, String line, Bridge bridge){
        List<Integer> lineAnswer = bridge.getAnswerLineIndex(line);
        if(lineAnswer.contains(index)){
            return BridgeShape.ANSWER_BRIDGE;
        }

        return BridgeShape.BLANK;
    }

    public void updateCurrentMap(int currentPosition, boolean isAlive){
        currentUpperLine = new ArrayList<>(upperAnswerLine.subList(0, currentPosition+1));
        currentLowerLine = new ArrayList<>(lowerAnswerLine.subList(0, currentPosition+1));
        if(!isAlive){
            changeSymbol();
        }
    }

    private void changeSymbol(){
        int lastIdx = currentUpperLine.size()-1;
        if(currentUpperLine.get(lastIdx).equals(BridgeShape.ANSWER_BRIDGE)){
            changeLastSymbol(BridgeShape.BLANK, BridgeShape.WRONG_BRIDGE);
        }
        if(currentUpperLine.get(lastIdx).equals(BridgeShape.ANSWER_BRIDGE)){
            changeLastSymbol(BridgeShape.WRONG_BRIDGE,BridgeShape.BLANK);
        }
    }

    private void changeLastSymbol(String upperSymbol, String lowerSymbol){
        int lastIdx = currentUpperLine.size()-1;
        currentUpperLine.set(lastIdx, upperSymbol);
        currentLowerLine.set(lastIdx, lowerSymbol);
    }

    public HashMap<String, List<String>> getCurrentMap(){
        HashMap<String, List<String>> currentMap = new HashMap<>();
        currentMap.put(BridgeRoute.UP.getRouth(), currentUpperLine);
        currentMap.put(BridgeRoute.DOWN.getRouth(), currentLowerLine);
        return currentMap;
    }
}
