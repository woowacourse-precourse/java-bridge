package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<SpotInfo> bridgeMap;

    public Bridge(List<String> bridgeInfo) {
        bridgeMap = new ArrayList<>();
        for(String spotInfoText : bridgeInfo) {
            bridgeMap.add(makeSpotInfo(spotInfoText));
        }
    }

    public int getBridgeLength() {
        return bridgeMap.size();
    }

    public boolean isSafeSpot(int index, SpotInfo spotInfo) {
        SpotInfo spotInfoOnIndex = bridgeMap.get(index);
        return spotInfoOnIndex.equals(spotInfo);
    }

    private SpotInfo makeSpotInfo(String spotInfoText) {
        if(spotInfoText.equals("U")) {
            return SpotInfo.UP;
        }
        if(spotInfoText.equals("D")) {
            return SpotInfo.DOWN;
        }
        throw new IllegalArgumentException("다리를 생성할 때는 U 혹은 D 중 하나를 이용해 생성합니다.");
    }
}
