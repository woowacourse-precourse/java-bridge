package bridge;


import bridge.constant.Constant;

import java.util.List;

public enum BridgeMapGenerator {

    RIGHT_ANSWER_INPUT_UP("O", " "),
    RIGHT_ANSWER_INPUT_DOWN(" ", "O"),
    WRONG_ANSWER_INPUT_UP("X", " "),
    WRONG_ANSWER_INPUT_DOWN(" ", "X"),;

    private final String resultOfUp;
    private final String resultOfDown;

    BridgeMapGenerator(String resultOfUp, String resultOfDown) {
        this.resultOfUp = resultOfUp;
        this.resultOfDown = resultOfDown;
    }

    public static List<List<String>> generateRightAnswerMap(String moving, List<List<String>> bridgeMap) {
        if (moving.equals(Constant.UP)) {
            generateMap(RIGHT_ANSWER_INPUT_UP, bridgeMap);
            return bridgeMap;
        }
        generateMap(RIGHT_ANSWER_INPUT_DOWN, bridgeMap);
        return bridgeMap;
    }

    public static List<List<String>> generateWrongAnswerMap(String moving, List<List<String>> bridgeMap) {
        if (moving.equals(Constant.UP)) {
            generateMap(WRONG_ANSWER_INPUT_UP, bridgeMap);
            return bridgeMap;
        }
        generateMap(WRONG_ANSWER_INPUT_DOWN, bridgeMap);
        return bridgeMap;
    }

    private static void generateMap(BridgeMapGenerator bridgeMapGenerator, List<List<String>> bridgeMap) {
        bridgeMap.get(0).add(bridgeMapGenerator.resultOfUp);
        bridgeMap.get(1).add(bridgeMapGenerator.resultOfDown);
    }
}
