package bridge;

import java.util.Arrays;

public enum BridgeEnum {
    UP_TRUE(1,"U",true,"O"),
    UP_FALSE(1,"U",false,"X"),
    DOWN_TRUE(0,"D",true,"O"),
    DOWN_FALSE(0,"D",false,"X");

    private final int bridgeNumberType;
    private final String bridgeStringType;
    private final boolean correctLocation;
    private final String checkLocation;


    BridgeEnum(int numberType, String stringType,boolean correctLocation,String checkLocation) {
        this.bridgeNumberType = numberType;
        this.bridgeStringType = stringType;
        this.correctLocation = correctLocation;
        this.checkLocation = checkLocation;
    }

    public static BridgeEnum createBridgeNumberType(int locationNumber) {
        return Arrays.stream(values())
                .filter(pointValue -> pointValue.bridgeNumberType == locationNumber)
                .findFirst()
                .orElseThrow();
    }

    public static BridgeEnum createBridgeStringType(String location, boolean correctLocation) {
        return Arrays.stream(values())
                .filter(locationValue -> isLocation(locationValue, location)
                        && isCorrectLocation(locationValue, correctLocation))
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
