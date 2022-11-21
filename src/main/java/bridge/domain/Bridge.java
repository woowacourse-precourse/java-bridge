package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridgeMap;

    public Bridge(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
    }

    public Boolean checkPassableBlock(Integer currentPosition, String selectBlock) {
        // TODO : 인덱스가 범위를 벗어나는 경우에 대해서 처리해야 함
        String passableBlock = bridgeMap.get(currentPosition + 1);
        if (selectBlock.equals(passableBlock)) return true;
        return false;
    }

    public Boolean checkWhetherLastBlock(Integer currentPosition) {
        if (currentPosition == bridgeMap.size() - 1) return true;
        return false;
    }

    public List<String> getBridgeMapUntil(Integer currentPosition) {
        return bridgeMap.subList(0, currentPosition + 1);
    }
}
