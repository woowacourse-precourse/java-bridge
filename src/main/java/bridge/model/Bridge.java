package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final static String STEP_EMPTY = " ";
    private final static String STEP_CORRECT = "O";
    private final static String STEP_WRONG = "X";
    private List<List<String>> bridgeMap;
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }

    public void makeAllMap(List<String> playerMove) {
        this.bridgeMap = Arrays.stream(Move.values())
                .map(move -> makeEachMap(move.getCommand(), playerMove))
                .collect(Collectors.toList());
    }

    private List<String> makeEachMap(String way, List<String> playerMove) {
        List<String> result = new ArrayList<>();

        for (int index = 0; index < playerMove.size(); index++) {
            String resultStep = checkStep(way, playerMove.get(index), bridge.get(index));
            result.add(resultStep);
        }
        return result;
    }

    private String checkStep(String way, String playerStep, String answerStep) {
        if (!way.equals(playerStep)) {
            return STEP_EMPTY;
        }
        return checkSameStep(playerStep, answerStep);
    }

    private String checkSameStep(String playerStep, String answerStep) {
        if (!answerStep.equals(playerStep)) {
            return STEP_WRONG;
        }
        return STEP_CORRECT;
    }
}
