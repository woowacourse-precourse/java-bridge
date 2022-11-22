package bridge.model;

import bridge.standard.BridgeForm;
import bridge.standard.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGame {

    private static List<List<String>> currentPositions;
    private static int numberOfAttempts;
    private static String outcome;

    public BridgeGame() {
        currentPositions = new ArrayList<>();
        numberOfAttempts = 1;
        outcome = "";
    }

    public void move(String userMoving, String bridgeStage, int bridgeSize) {
        List<String> position = Arrays.asList(" ", " ");
        Stage stage = Stage.judge(userMoving.equals(bridgeStage));
        position.set(BridgeForm.transferByCode(userMoving), stage.getMark());

        currentPositions.add(position);
        outcome = stage.getOutcome();

        if (currentPositions.size() == bridgeSize && !outcome.equals(Rule.STAGE_FAIL)) {
            outcome = Rule.STAGE_SUCCESS;
        }
    }

    public boolean isSuccess() {
        return outcome.equals(Rule.STAGE_SUCCESS);
    }

    public boolean isFail() {
        return outcome.equals(Rule.STAGE_FAIL);
    }

    public void retry() {
        currentPositions.clear();
        numberOfAttempts++;
        outcome = "";
    }


    public int nextIndex() {
        return currentPositions.size();
    }

    public List<List<String>> getCurrentPositions() {
        return currentPositions;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public String getOutcome() {
        return outcome;
    }

}