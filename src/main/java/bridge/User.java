package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Result> results;
    private int correctStepNumber;

    public User() {
        this.results = new ArrayList<>();
        correctStepNumber = 0;
    }

    public boolean move(List<String> bridge, String direction) {
        boolean isSuccess = false;
        if (bridge.get(correctStepNumber).equals(direction)) {
            correctStepNumber++;
            isSuccess = true;
        }
        this.results.add(new Result(direction, isSuccess));
        return isSuccess;
    }

    public List<Result> makeGameResult() {
        List<Result> gameResult = new ArrayList<>();
        int recentResultIndex = results.size() - 1;

        addOnlySuccess(gameResult);
        gameResult.add(results.get(recentResultIndex));
        return gameResult;
    }

    private void addOnlySuccess(List<Result> gameResult){
        for (int i = 0; i < results.size() - 1; i++) {
            if (results.get(i).isSuccess()) {
                gameResult.add(results.get(i));
            }
        }
    }
}
