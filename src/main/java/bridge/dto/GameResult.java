package bridge.dto;

public class GameResult {
    private final UserState userState;
    private final boolean isSuccess;
    private final int numberOfAttempts;

    public GameResult(UserState userState, boolean isSuccess, int numberOfAttempts) {
        this.userState = userState;
        this.isSuccess = isSuccess;
        this.numberOfAttempts = numberOfAttempts;
    }

    public UserState getUserState() {
        return userState;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
