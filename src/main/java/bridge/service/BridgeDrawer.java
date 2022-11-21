package bridge.service;

import bridge.type.DirectionType;
import bridge.type.ResultType;
import bridge.view.OutputView;
import utils.BridgePrintTool;

import java.util.ArrayList;
import java.util.List;

public class BridgeDrawer {
    public static List<String> userDirection = new ArrayList<>();
    private static List<String> directionTypeUP = new ArrayList<>();
    private static List<String> directionTypeDOWN = new ArrayList<>();
    private static List<List<String>> directionTypeLists = new ArrayList<>();
    ResultServiceImpl resultService = new ResultServiceImpl();

    
    public void initializeLists() {
        userDirection.clear();
        directionTypeUP.clear();
        directionTypeDOWN.clear();
        directionTypeLists.clear();
    }

    public static void concatDirectionTypeList() {
        directionTypeLists.add(directionTypeUP);
        directionTypeLists.add(directionTypeDOWN);
    }

    public void makePrintList(String directionType, List<String> bridgeInfo) {
        makeDirectionList(directionType, bridgeInfo);
    }


    public void makeDirectionList(String directionType, List<String> bridgeInfo) {
        if (directionType.equals(DirectionType.UP)) {
            directionTypeUP.add(getMatchResult(bridgeInfo));
            directionTypeDOWN.add(getBlankResult(bridgeInfo));
            return;
        }
        directionTypeUP.add(getBlankResult(bridgeInfo));
        directionTypeDOWN.add(getMatchResult(bridgeInfo));
    }


    public String getMatchResult(List<String> bridgeInfo) {
        String matchResult = resultService.isBetween(bridgeInfo) + resultService.makeMatchResult(bridgeInfo);
        return matchResult;
    }

    public String getBlankResult(List<String> bridgeInfo) {
        return resultService.isBetween(bridgeInfo) + BridgePrintTool.BLANK;
    }

    public boolean checkCrossable(List<String> bridgeInfo, String direction) {
        return compare(bridgeInfo, userDirection.size()-1, direction);
    }

    public boolean compare(List<String> bridgeInfo, int idx, String direction) {
        if ( bridgeInfo.get(idx).equals(direction)) {
            return true;
        }
        return false;
    }

    public List<String> saveUserDirection(String direction) {
        userDirection.add(direction);
        return userDirection;
    }


    public static boolean isSucceed(List<String> bridgeInfo) {
        if (bridgeInfo.size() == userDirection.size()) {
            return true;
        }
        return false;
    }


    public static void draw() {
        concatDirectionTypeList();
        OutputView.printMap(directionTypeLists);
    }

    public static void drawFinal(ResultType resultType, int tryCnt) {
        OutputView.printMap(directionTypeLists);
        OutputView.printResult(resultType, tryCnt);
    }
}
