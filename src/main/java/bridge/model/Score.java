package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private List<String> scoreBoard;

    public Score() {
        scoreBoard = new ArrayList<>();
    }

    public List<String> addGameResult(String result) {

        scoreBoard.add(result);

        return scoreBoard;
    }

    public List<String> getScoreBoard() {
        return scoreBoard;
    }

}
