package bridge.constant;

public enum GameSuccessOrNotStatus {
    Success("성공"),
    Not("실패");

    private final String gameSuccess;

    GameSuccessOrNotStatus(String gameSuccess) {
        this.gameSuccess = gameSuccess;
    }

    public String getGameSuccess() {
        return gameSuccess;
    }

    public static String getGameSuccessMessage(boolean gameSuccess){
        if (gameSuccess) {
            return Success.gameSuccess;
        }
        return Not.gameSuccess;
    }
}
