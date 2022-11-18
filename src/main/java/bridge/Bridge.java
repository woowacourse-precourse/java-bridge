package bridge;

import java.util.ArrayList;
import java.util.Collections;
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

    public void generateShape(String userInput, int idx) {
        validateInputIsUOrD(userInput);
        caseWhenUserInputIsU(userInput, idx);
        caseWhenUserInputIsD(userInput, idx);
    }

    private void caseWhenUserInputIsU(String userInput, int idx) {
        if (userInput == "U" && bridge.get(idx) == "U") {
            bridgeShape.get(0).add("O");
            bridgeShape.get(1).add(" ");
        }
        if (userInput == "U" && bridge.get(idx) == "D") {
            bridgeShape.get(0).add("X");
            bridgeShape.get(1).add(" ");
        }
    }

    private void caseWhenUserInputIsD(String userInput, int idx) {
        if (userInput == "D" && bridge.get(idx) == "U") {
            bridgeShape.get(1).add("X");
            bridgeShape.get(0).add(" ");
        }
        if (userInput == "D" && bridge.get(idx) == "D") {
            bridgeShape.get(1).add("O");
            bridgeShape.get(0).add(" ");
        }
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
