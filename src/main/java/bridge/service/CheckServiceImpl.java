package bridge.service;

import bridge.service.itf.CheckService;
import utils.BridgePrintTool;

import java.util.List;

public class CheckServiceImpl implements CheckService {

    @Override
    public String isMatch(List<String> bridgeInfo, int idx, List<String> userDirection) {
        if (bridgeInfo
                .get(idx)
                .equals(userDirection.get(idx))) {
            return BridgePrintTool.MATCH;
        }
        return BridgePrintTool.NOT_MATCH;
    }

    @Override
    public String isBetween(List<String> bridgeInfo) {
        int size = BridgeGame.getUserDirectionSize();
        if (size > 1 && size <= bridgeInfo.size()) {
            return BridgePrintTool.BETWEEN;
        }
        return BridgePrintTool.NONE;
    }

    @Override
    public boolean isSucceed(List<String> bridgeInfo) {
        if (bridgeInfo.size() == BridgeGame.getUserDirectionSize()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCrossable(List<String> bridgeInfo, String direction) {
        return compare(bridgeInfo, BridgeGame.getUserDirectionSize()-1, direction);
    }

    @Override
    public boolean compare(List<String> bridgeInfo, int idx, String direction) {
        if ( bridgeInfo.get(idx).equals(direction)) {
            return true;
        }
        return false;
    }
}
