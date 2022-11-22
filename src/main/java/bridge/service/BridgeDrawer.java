package bridge.service;

import bridge.type.DirectionType;
import bridge.type.ResultType;
import bridge.view.OutputView;
import utils.BridgePrintTool;

import java.util.ArrayList;
import java.util.List;

public class BridgeDrawer extends AbstractBridgeDrawer{

    public void initializeLists() {
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
            directionTypeUP.add(resultService.getMatchResult(bridgeInfo));
            directionTypeDOWN.add(resultService.getBlankResult(bridgeInfo));
            return;
        }
        directionTypeUP.add(resultService.getBlankResult(bridgeInfo));
        directionTypeDOWN.add(resultService.getMatchResult(bridgeInfo));
    }

    public List<List<String>> getDirectionTypeLists() {
        concatDirectionTypeList();
        return directionTypeLists;
    }
}
