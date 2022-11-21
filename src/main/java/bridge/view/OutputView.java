package bridge.view;

import java.util.List;

import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.util.MessageUtil;

public class OutputView {

    private static final Boolean CORRECT_ANSWER_IDENTIFIER = Boolean.TRUE;
    private static final String UPPER_DIRECTION_IDENTIFIER = "U";
    private static final String LOWER_DIRECTION_IDENTIFIER = "D";
    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]\n";
    private static final String DIVIDER = "|";
    private static final String SUCCESS_INDICATOR = " O ";
    private static final String FAILURE_INDICATOR = " X ";
    private static final String BLANK_INDICATOR = "   ";

    public static void printMap(Result result, Player player) {
        String upperMap = OPENING_BRACKET;
        String lowerMap = OPENING_BRACKET;
        for (int distance = 0; distance < player.getDistance(); distance++) {
            upperMap += isUpperMap(distance, player, result);
            lowerMap += isLowerMap(distance, player, result);
        }
        String map = setAndSaveMapForPrint(result, upperMap, lowerMap);
        System.out.println(map);
    }

    private static String isUpperMap(int index, Player player, Result result) {
        List<Movement> route = player.getRoute();
        if (route.get(index).getDirection().equals(UPPER_DIRECTION_IDENTIFIER)) {
            return isTrueOrFalse(index, result);
        }
        return BLANK_INDICATOR+DIVIDER;
    }

    private static String isLowerMap(int index, Player player, Result result) {
        List<Movement> route = player.getRoute();
        if (route.get(index).getDirection().equals(LOWER_DIRECTION_IDENTIFIER)) {
            return isTrueOrFalse(index, result);
        }
        return BLANK_INDICATOR+DIVIDER;
    }

    private static String isTrueOrFalse(int index, Result result) {
        List<Boolean> gameResult = result.getGameResult();
        if (gameResult.get(index).equals(CORRECT_ANSWER_IDENTIFIER)) {
            return SUCCESS_INDICATOR+DIVIDER;
        }
        return FAILURE_INDICATOR+DIVIDER;
    }

    private static String setAndSaveMapForPrint(Result result, String upperMap, String lowerMap) {
        upperMap = upperMap.substring(0, upperMap.length() - 1);
        upperMap += CLOSING_BRACKET;
        lowerMap = lowerMap.substring(0, lowerMap.length() - 1);
        lowerMap += CLOSING_BRACKET;
        String map = upperMap + lowerMap;
        result.setResultMap(map);
        return map;
    }

    public static void printResult(Result result) {
        String resultMap = result.getResultMap();
        String successOrFailure = result.getSuccessOrFailure();
        int numberOfTrials = result.getNumberOfTrials();
        MessageUtil.gameResultMsg(resultMap, successOrFailure, numberOfTrials);
    }
}
