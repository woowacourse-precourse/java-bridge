package bridge.domain;

public enum BridgeLane {
    UP,
    DOWN;

    public static BridgeLane makeBridgeLane(String laneInfoText) {
        if(laneInfoText.equals("U")) {
            return BridgeLane.UP;
        }
        if(laneInfoText.equals("D")) {
            return BridgeLane.DOWN;
        }
        throw new IllegalArgumentException("다리를 생성할 때는 U 혹은 D 중 하나를 이용해 생성합니다.");
    }
}