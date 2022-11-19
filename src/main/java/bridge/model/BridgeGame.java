package bridge.model;

import bridge.standard.GameForm;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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
        currentPositions.add(Stage.judge(userMoving, bridgeStage));

        if (currentPositions.size() == bridgeSize) {
            outcome = GameForm.SUCCESS_MARK;
        }
        if (currentPositions.get(currentPositions.size() - 1).contains(GameForm.WRONG_MARK)) {
            outcome = GameForm.FAILS_MARK;
        }
    }

    public boolean isSuccess() {
        return outcome.equals(GameForm.SUCCESS_MARK);
    }

    public boolean isFail() {
        return outcome.equals(GameForm.FAILS_MARK);
    }

    public void retry() {
        numberOfAttempts++;
        currentPositions.clear();
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
