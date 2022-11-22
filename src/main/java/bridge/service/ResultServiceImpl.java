package bridge.service;

import bridge.service.itf.CheckService;
import bridge.service.itf.ResultService;
import utils.BridgePrintTool;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    CheckService checkService = new CheckServiceImpl();


    @Override
    public String makeMatchResult(List<String> bridgeInfo) {
        int idx = BridgeGame
                .getUserDirection()
                .size()-1;
        return checkService.isMatch(bridgeInfo, idx, BridgeGame.getUserDirection());
    }


    public String getMatchResult(List<String> bridgeInfo) {
        String matchResult = checkService.isBetween(bridgeInfo) + makeMatchResult(bridgeInfo);
        return matchResult;
    }

    public String getBlankResult(List<String> bridgeInfo) {
        return checkService.isBetween(bridgeInfo) + BridgePrintTool.BLANK;
    }
}
