package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Result> results;
    private int challengeStep;
    private int retryCount;

    public Player() {
        this.results = new ArrayList<>();
        challengeStep = 0;
        retryCount = 1;
    }

    public int move(List<String> bridge, String direction) {
        boolean isSuccess = false;

        if (bridge.get(challengeStep).equals(direction)) {
            challengeStep++;
            isSuccess = true;
        }

        this.results.add(new Result(direction, isSuccess));
        return challengeStep;
    }

    public List<Result> makeGameResult() {
        List<Result> gameResult = new ArrayList<>();
        int recentResultIndex = results.size() - 1;

        addOnlySuccess(gameResult);
        gameResult.add(results.get(recentResultIndex));
        return gameResult;
    }

    public boolean lastResultIsSuccess() {
        return results.get(results.size() - 1).isSuccess();
    }

    private void addOnlySuccess(List<Result> gameResult) {
        for (int i = 0; i < results.size() - 1; i++) {
            if (results.get(i).isSuccess()) {
                gameResult.add(results.get(i));
            }
        }
    }

    public void upRetryCount() {
        this.retryCount += 1;
    }

    public int getRetry() {
        return retryCount;
    }
}
