package bridge;

public class GameCommandJudge {
    private static String retry = "R";
    private static String quit = "Q";

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
