package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final List<List<String>> bridgeShape = new ArrayList<>();

    Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
        for (int idx = 0; idx < 2; idx++) {
            bridgeShape.add(new ArrayList<>());
        }
    }

    public boolean generateShapeAndReturnWhetherUserGetTheRightAnswer(String userInput, int idx) {
        validateInputIsUOrD(userInput);
        boolean isUserGetTheRightAnswer = true;
        if (userInput == "U") {
            isUserGetTheRightAnswer = caseWhenUserInputIsU(idx);
        }
        if (userInput == "D") {
            isUserGetTheRightAnswer = caseWhenUserInputIsD(idx);
        }
        return isUserGetTheRightAnswer;
    }

    private boolean caseWhenUserInputIsU(int idx) {
        if (bridge.get(idx) == "U") {
            bridgeShape.get(0).add("O");
            bridgeShape.get(1).add(" ");
        }
        if (bridge.get(idx) == "D") {
            bridgeShape.get(0).add("X");
            bridgeShape.get(1).add(" ");
            return false;
        }
        return true;
    }

    private boolean caseWhenUserInputIsD(int idx) {
        if (bridge.get(idx) == "U") {
            bridgeShape.get(1).add("X");
            bridgeShape.get(0).add(" ");
            return false;
        }
        if (bridge.get(idx) == "D") {
            bridgeShape.get(1).add("O");
            bridgeShape.get(0).add(" ");
        }
        return true;
    }

    public void retry() {
        bridgeShape.get(0).clear();
        bridgeShape.get(1).clear();
    }

    private void validateInputIsUOrD(String userInput) {
        if (userInput != "U" && userInput != "D") {
            throw new IllegalArgumentException("[ERROR] U와 D만 입력할 수 있습니다.");
        }
    }

    public List<String> getBridgeUpperSide() {
        return new ArrayList<>(bridgeShape.get(0));
    }

    public List<String> getBridgeDownSide() {
        return new ArrayList<>(bridgeShape.get(1));
    }
}
