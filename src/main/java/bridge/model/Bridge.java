package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<SpotInfo> bridgeMap;

    public Bridge(List<String> bridgeInfo) {
        bridgeMap = new ArrayList<>();
        for(String spotInfoText : bridgeInfo) {
            bridgeMap.add(SpotInfo.makeSpotInfo(spotInfoText));
        }
    }

    public Bridge(Bridge oth) {
        bridgeMap = new ArrayList<>(oth.bridgeMap);
    }

    public int getBridgeLength() {
        return bridgeMap.size();
    }

    public boolean isSafeSpot(int index, SpotInfo spotInfo) {
        SpotInfo spotInfoOnIndex = bridgeMap.get(index - 1);
        return spotInfoOnIndex.equals(spotInfo);
    }
}
