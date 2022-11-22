package bridge.service;

import java.util.Arrays;
import java.util.Optional;

public enum Location {
    DOWN(0, "D"),
    UP(1, "U");

    private int locationNumber;
    private String locationInitial;

    public static Optional<Location> getBridgeLocation(int locationNumber) {
        return Arrays.stream(Location.values())
                .filter(x -> x.locationNumber == locationNumber)
                .findFirst();
    }

    public static String getBridgeLocationInitial(int locationNumber) {
        return getBridgeLocation(locationNumber).get().getLocationInitial();
    }

    Location(int locationNumber, String locationInitial) {
        this.locationInitial = locationInitial;
        this.locationNumber = locationNumber;
    }

    public String getLocationInitial() {
        return locationInitial;
    }
}
