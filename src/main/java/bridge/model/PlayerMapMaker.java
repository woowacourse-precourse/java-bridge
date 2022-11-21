package bridge.model;

import java.util.List;

public class PlayerMapMaker {

    private final PlayerMap successMap;
    private final PlayerMap failureMap;

    public PlayerMapMaker(List<String> bridge) {
        BridgeMapMaker bridgeMapMaker = new BridgeMapMaker(bridge);
        successMap = bridgeMapMaker.getSuccessBridgeMap();
        failureMap = bridgeMapMaker.getFailureBridgeMap();
    }

    public PlayerMap makeSuccessPlayerMapTo(int distance) {
        return successMap.subMapBy(distance);
    }

    public PlayerMap makeFailurePlayerMapTo(int distance) {
        PlayerMap successSubMap = successMap.subMapBy(distance - 1);
        PlayerMap failureElement = failureMap.getElementOf(distance);

        return successSubMap.join(failureElement);
    }

    @Override
    public String toString(){
        return "< PlayerMapMaker successMap=" + successMap.toStringsByFormat(MapFormat.FORMAT) + " >";
    }
}
