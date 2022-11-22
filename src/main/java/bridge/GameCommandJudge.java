package bridge;

public class GameCommandJudge {
    private String retry = "R";
    private String quit = "Q";

    public Boolean checkPlayerWantsRetrial(String gameCommand) {
        if (gameCommand.equals(retry)) {
            return true;
        }
        if (gameCommand.equals(quit)) {
            return false;
        }
        return null;
    }
}
