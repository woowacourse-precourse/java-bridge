package bridge;

import java.util.Arrays;

public enum BridgeEnum {
    UP_TRUE("U", 1, true, "O"),
    UP_FALSE("U", 1, false, "X"),
    DOWN_TRUE("D", 0, true, "O"),
    DOWN_FALSE("D", 0, false, "X");

    private final String bridgeStringType;
    private final int bridgeNumberType;
    private final boolean correctLocation;
    private final String checkLocation;


    BridgeEnum(String stringType, int numberType, boolean correctLocation, String checkLocation) {
        this.bridgeStringType = stringType;
        this.bridgeNumberType = numberType;
        this.correctLocation = correctLocation;
        this.checkLocation = checkLocation;
    }

    public static BridgeEnum createBridgeStringType(String location, boolean correctLocation) {
        return Arrays.stream(values())
                .filter(locationValue -> isLocation(locationValue, location)
                        && isCorrectLocation(locationValue, correctLocation))
                .findFirst()
                .orElseThrow();
    }

    public static BridgeEnum createBridgeNumberType(int locationNumber) {
        return Arrays.stream(values())
                .filter(pointValue -> pointValue.isLocationNumber(pointValue, locationNumber))
                .findFirst()
                .orElseThrow();
    }


    private static boolean isLocationNumber(BridgeEnum locationValue, int locationNumber) {
        return locationValue.bridgeNumberType == locationNumber;
    }

    private static boolean isCorrectLocation(BridgeEnum locationValue, boolean correctLocation) {
        return locationValue.correctLocation == correctLocation;
    }

    private static boolean isLocation(BridgeEnum locationValue, String location) {
        return locationValue.bridgeStringType.equals(location);
    }

    public String getStringType() {
        return bridgeStringType;
    }

    public boolean getCorrectLocation() {
        return correctLocation;
    }

    public String getStateLocation(String location) {
        if (this.bridgeStringType.equals(location)) {
            return checkLocation;
        }
        return " ";
    }

}
