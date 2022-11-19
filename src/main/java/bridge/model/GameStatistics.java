package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class GameStatistics {
    private String gameResult;
    private int totalTryCount;
    private List<String> answerRoad;
    private ArrayList<Boolean> checkRoad;

    public GameStatistics() {
        this.totalTryCount = 1;
        answerRoad = new ArrayList<>();
        initCheckRoad();
    }

    public String getGameResult() {
        return gameResult;
    }

    public String getTotalTryCount() {
        return Integer.toString(totalTryCount);
    }

    public List<Boolean> getCheckRoad() {
        return checkRoad;
    }

    public List<String> getAnswerRoad() {
        return answerRoad;
    }

    public void setAnswerRoad(List<String> answerRoad) {
        this.answerRoad = answerRoad;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public void increaseTotalTryCount() {
        this.totalTryCount += 1;
    }

    public void initCheckRoad() {
        checkRoad = new ArrayList<>();
    }
}
