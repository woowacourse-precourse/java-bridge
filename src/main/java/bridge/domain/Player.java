package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int position;
    private List<String> gameHistory = new ArrayList<>();
    private String lastChoice;
    private boolean checkAnswer;

    public Player() {
        initialize();
    }

    public void initialize() {
        position = -1;
        gameHistory.clear();
    }
}
