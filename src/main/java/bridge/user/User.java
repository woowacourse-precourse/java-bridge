package bridge.user;

/**
 * 사용자 상태 관리
 */
public class User {

    private boolean isPlayingGame;
    private int userGameStatus;
    private int numberOfMoves;
    private int numberOfGameTrials;

    public enum GameStatus {
        NONE(0),
        SUCCEED(1),
        FAILED(2);

        int statusNumber;

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

        private String command;

        GameCommand(String command) {
            this.command = command;
        }

        public String getCommand() {
            return command;
        }
    }

    public User(boolean isPlayingGame, int userGameStatus, int numberOfGameTrials) {
        this.isPlayingGame = isPlayingGame;
        this.userGameStatus = userGameStatus;
        this.numberOfGameTrials = numberOfGameTrials;
    }

    // getter
    public boolean isPlayingGame() {
        return isPlayingGame;
    }

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
    public void setNotPlayingGame() {
        isPlayingGame = false;
    }

    public void setUserGameStatus_succeed() {
        userGameStatus = GameStatus.SUCCEED.getStatusNumber();
    }

    public void setUserGameStatus_failed() {
        userGameStatus = GameStatus.FAILED.getStatusNumber();
    }

    // method
    public void resetNumberOfMoves() {
        numberOfMoves = 0;
    }

    public void increaseNumberOfGameTrials() {
        numberOfGameTrials += 1;
    }

    public void increaseNumberOfMoves() {
        numberOfMoves += 1;
    }

}
