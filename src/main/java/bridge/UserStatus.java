package bridge;


import java.util.List;

public class UserStatus {
    private int userAttempt;
    private int userLocation;
    private final int bridgeLength;

    public UserStatus(List<String> bridge) {
        this.bridgeLength = bridge.size();
        this.userAttempt = 0;
        this.userLocation = 0;
    }

    public int getUserAttempt() {
        return userAttempt;
    }

    public int getUserLocation() {
        return userLocation;
    }

    public void addUserAttempt() {
        this.userAttempt++;
    }

    public void addUserLocation() {
        this.userLocation++;
    }
}
