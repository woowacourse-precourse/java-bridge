package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Boolean> results;
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
        this.results.add(isSuccess);
        return isSuccess;
    }

    public List<Boolean> makeGameResult() {
        List<Boolean> gameResult = new ArrayList<>();
        int recentResultIndex = results.size() - 1;

        addOnlySuccess(gameResult);
        gameResult.add(results.get(recentResultIndex));
        return gameResult;
    }

    private void addOnlySuccess(List<Boolean> gameResult){
        for (int i = 0; i < results.size() - 1; i++) {
            if (results.get(i)) {
                gameResult.add(results.get(i));
            }
        }
    }
}
