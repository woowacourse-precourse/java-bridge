package bridge.domain;

import bridge.utils.constants.BridgeRoute;
import bridge.utils.constants.BridgeShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BridgeMap {
    private final List<String> upperAnswerLine = new ArrayList<>();
    private final List<String> lowerAnswerLine = new ArrayList<>();
    private List<String> currentUpperLine;
    private List<String> currentLowerLine;

    public BridgeMap(Bridge bridge){
        makeBridgeMap(bridge);
        initializeCurrentMap();
    }

    private void makeBridgeMap(Bridge bridge){
        lineMaker(BridgeRoute.UP.getRoute(), bridge, upperAnswerLine);
        lineMaker(BridgeRoute.DOWN.getRoute(), bridge, lowerAnswerLine);
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
        if(currentLowerLine.get(lastIdx).equals(BridgeShape.ANSWER_BRIDGE)){
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
        currentMap.put(BridgeRoute.UP.getRoute(), currentUpperLine);
        currentMap.put(BridgeRoute.DOWN.getRoute(), currentLowerLine);
        return currentMap;
    }

    public void initializeCurrentMap(){
        this.currentUpperLine = new ArrayList<>();
        this.currentLowerLine = new ArrayList<>();
    }
}
