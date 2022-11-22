package bridge;

import java.util.ArrayList;
import java.util.List;

public class MapMaker {

    public final String PASSED = " O ";
    public final String NOTPASSED = "   ";
    public final String WRONGPASS = " X ";
    public final String DIVISIONLINE = "|";

    public String makeUpperMap(List<String> bridge, int round){
        String upperMap = "";
        for (int index = 0; index < round; index++){
            upperMap += translateMoveToUpperMapElement(bridge.get(index)) + DIVISIONLINE;
        }
        if(upperMap.length() >= 2) {
            upperMap.substring(0, upperMap.length());
        }
        return upperMap;
    }

    public String translateMoveToUpperMapElement(String move){
        if (move == "U"){
            return PASSED;
        }
        return NOTPASSED;
    }

    public String makeLowerMap(List<String> bridge, int round){
        String lowerMap = "";
        for (int index = 0; index < round; index++){
            lowerMap += translateMoveToUpperMapElement(bridge.get(index)) + DIVISIONLINE;
        }
        if(lowerMap.length() >= 2) {
            lowerMap.substring(0, lowerMap.length());
        }
        return lowerMap;
    }

    public String translateMoveToLowerMapElement(String move){
        if (move == "D"){
            return PASSED;
        }
        return NOTPASSED;
    }

    public List <String> makeWrongPassMap(List<String> bridge, int round, String inputMove){
        if (inputMove == "U"){
            return makeWrongUCaseMap(bridge,round);
        }
        return makeWrongDCaseMap(bridge,round);
    }

    public List <String> makeWrongUCaseMap(List <String> bridge, int round){
        List<String> wrongPassMap = new ArrayList<>();
        wrongPassMap.add(makeUpperMap(bridge,round) + DIVISIONLINE + WRONGPASS);
        wrongPassMap.add(makeLowerMap(bridge,round) + DIVISIONLINE + NOTPASSED);
        return wrongPassMap;
    }

    public List <String> makeWrongDCaseMap(List <String> bridge, int round){
        List<String> wrongPassMap = new ArrayList<>();
        wrongPassMap.add(makeUpperMap(bridge,round) + DIVISIONLINE + NOTPASSED);
        wrongPassMap.add(makeLowerMap(bridge,round) + DIVISIONLINE + WRONGPASS);
        return wrongPassMap;
    }

}
