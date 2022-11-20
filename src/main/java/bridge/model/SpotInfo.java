package bridge.model;

public enum SpotInfo {
    UP,
    DOWN;

    public static SpotInfo makeSpotInfo(String spotInfoText) {
        if(spotInfoText.equals("U")) {
            return SpotInfo.UP;
        }
        if(spotInfoText.equals("D")) {
            return SpotInfo.DOWN;
        }
        throw new IllegalArgumentException("다리를 생성할 때는 U 혹은 D 중 하나를 이용해 생성합니다.");
    }
}