package bridge.model;

import bridge.service.UserInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final List<List<String>> resultBridges = new ArrayList<>();
    private final Map<Boolean, String> ox = new HashMap<>();
    private int tryCount = 1;
    private boolean success = true;

    public Result() {
        initialize();
        ox.put(true, "O");
        ox.put(false, "X");
    }

    public void initialize() {
        resultBridges.clear();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        resultBridges.add(upperBridge);
        resultBridges.add(lowerBridge);
    }

    public int getTryCount() {
        return tryCount;
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void setSuccessToFail() {
        success = false;
    }

    public String getSuccess() {
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public void storeResultBridges(String moving, boolean crossedBridge) {
        List<String> upperBridge = resultBridges.get(0);
        List<String> lowerBridge = resultBridges.get(1);
        if (moving.equals(UserInput.InputLetter.MOVING_UP.getLetter())) {
            upperBridge.add(ox.get(crossedBridge));
            lowerBridge.add(" ");
        }
        if (moving.equals(UserInput.InputLetter.MOVING_DOWN.getLetter())) {
            upperBridge.add(" ");
            lowerBridge.add(ox.get(crossedBridge));
        }
    }

    public String getResultBridges() {
        StringBuilder result = new StringBuilder();
        for (List<String> resultBridge : resultBridges) {
            result.append(String.valueOf(resultBridge)
                    .replace(", ", " | ")
                    .replace("[", "[ ")
                    .replace("]", " ]\n"));
        }
        return result.toString();
    }
}
