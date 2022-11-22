package bridge.util;

public class Judge {

    public String isCorrect(String bridge, String player) {
        if (bridge.equals(player)) {
            return " O |";
        }
        return " X |";
    }
}
