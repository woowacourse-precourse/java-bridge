package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int position;
    private List<String> gameHistory = new ArrayList<>();
    private String lastChoice;
    private boolean result;

    public Player() {
        initialize();
    }

    public void initialize() {
        position = -1;
        gameHistory.clear();
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        return ++position;
    }

    public void saveHistory() {
        gameHistory.add(lastChoice);
    }

    public void saveLastChoice(String lastChoice, boolean result) {
        this.lastChoice = lastChoice;
        this.result = result;
    }
}
