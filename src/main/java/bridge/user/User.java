package bridge.user;

/**
 * 사용자의 상태값을 관리
 */
public class User {

    private int userGameStatus;
    private int numberOfMoves;
    private int numberOfGameTrials;

    public enum GameStatus {
        PLAYING(0),
        SUCCEED(1),
        FAILED(2);

        private final int statusNumber;

        GameStatus(int statusNumber) {
            this.statusNumber = statusNumber;
        }

        public int getStatusNumber() {
            return statusNumber;
        }
    }

    public enum GameCommand {
        RETRY("R"),
        QUIT("Q");

        private final String command;

        GameCommand(String command) {
            this.command = command;
        }

        public String getCommand() {
            return command;
        }
    }

    // constructor
    public User(int userGameStatus, int numberOfGameTrials) {
        this.userGameStatus = userGameStatus;
        this.numberOfGameTrials = numberOfGameTrials;
    }

    // getter
    public int getUserGameStatus() {
        return userGameStatus;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public int getNumberOfGameTrials() {
        return numberOfGameTrials;
    }

    // setter
    public void setUserGameStatus_succeed() {
        userGameStatus = GameStatus.SUCCEED.getStatusNumber();
    }

    public void setUserGameStatus_failed() {
        userGameStatus = GameStatus.FAILED.getStatusNumber();
    }

    // methods
    public void increaseNumberOfMoves() {
        numberOfMoves += 1;
    }

    public void increaseNumberOfGameTrials() {
        numberOfGameTrials += 1;
    }

    public void resetNumberOfMoves() {
        numberOfMoves = 0;
    }

}
