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

    public void move(String userMoving, String bridgeStage) {
        currentPositions.add(Stage.judge(userMoving, bridgeStage));
        if (currentPositions.get(currentPositions.size() - 1).contains(GameForm.WRONG_CODE)) { //이동마다 x가 포함됐는지 확인
            outcome = GameForm.FAILS;
        }
    }

    public void retry() {
        numberOfAttempts++;
        currentPositions.clear();
        outcome = "";
    }

    public boolean inProgress(int bridgeSize) {
        if (currentPositions.size() == bridgeSize) {
            outcome = GameForm.SUCCESS;
            return false;
        }
        return true;
    }

    public boolean isFail() {
        return outcome.equals(GameForm.FAILS);
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
