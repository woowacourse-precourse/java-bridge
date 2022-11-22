package bridge.domain;

import bridge.constant.Constant;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private int totalTry = 1;
    private boolean wrongAnswer = false;
    private List<List<String>> bridgeMap = new ArrayList<>();

    public void initMap() {
        wrongAnswer = false;
        bridgeMap.clear();
        for (int i = 0; i < Constant.BRIDGE_WIDTH; i++) {
            bridgeMap.add(new ArrayList<>());
        }
    }

    public List<List<String>> move(String answer, String moving) {
        if (answer.equals(moving)) {
            return BridgeMapGenerator.generateRightAnswerMap(moving, bridgeMap);
        }
        wrongAnswer = true;
        return BridgeMapGenerator.generateWrongAnswerMap(moving, bridgeMap);
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals(Constant.RESTART)) {
            totalTry++;
            return true;
        }
        return false;
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }

    public boolean isWrongAnswer() {
        return wrongAnswer;
    }

    public int countTotalTry() {
        return totalTry;
    }
}
