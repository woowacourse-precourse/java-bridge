package bridge;


import java.util.List;

public class UserStatus {
    private int userAttempt;
    private int userLocation;
    private final int bridgeLength;
    private boolean gameResultSuccess;

    public UserStatus(List<String> bridge) {
        this.bridgeLength = bridge.size();
        this.userAttempt = 0;
        this.userLocation = 0;
        this.gameResultSuccess = false;
    }

    public void setGameResultSuccess() {
        this.gameResultSuccess = true;
    }

    public boolean isGameResultSuccess() {
        return gameResultSuccess;
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

    public void resetUserLocation() {
        this.userLocation = 0;
    }
}
