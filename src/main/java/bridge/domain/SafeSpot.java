package bridge.domain;


public enum SafeSpot {
    DOWN(0,"D"),
    UP(1,"U");

    private final int locationNum;
    private final String location;

    SafeSpot(int locationNum, String location) {
        this.locationNum = locationNum;
        this.location = location;
    }

    public static String locationOf(int locationNum){
        for (SafeSpot spot : SafeSpot.values()){
            if (locationNum == spot.locationNum){
                return spot.location;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 위치 숫자입니다");
    }
}
