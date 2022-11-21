package bridge.view;

import java.util.List;
import java.util.Collections;

import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.util.MessageUtil;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Result result, Player player) {
        String upperMap = "[";
        String lowerMap = "[";
        for (int distance = 0; distance < player.getDistance(); distance++) {
            upperMap += isUpperMap(distance, player, result);
            lowerMap += isLowerMap(distance, player, result);
        }
        String map = setAndSaveMapForPrint(result, upperMap, lowerMap);
        System.out.println(map);
    }

    private static String isUpperMap(int index, Player player, Result result) {
        List<Movement> route = player.getRoute();
        if (route.get(index).getDirection().equals("U")) {
            return isTrueOrFalse(index, result);
        }
        return "   |";
    }

    private static String isLowerMap(int index, Player player, Result result) {
        List<Movement> route = player.getRoute();
        if (route.get(index).getDirection().equals("D")) {
            return isTrueOrFalse(index, result);
        }
        return "   |";
    }

    private static String isTrueOrFalse(int index, Result result) {
        List<Boolean> gameResult = result.getGameResult();
        if (gameResult.get(index).equals(Boolean.TRUE)) {
            return " O |";
        }
        return " X |";
    }

    private static String setAndSaveMapForPrint(Result result, String upperMap, String lowerMap) {
        upperMap = upperMap.substring(0, upperMap.length() - 1);
        upperMap += "]\n";
        lowerMap = lowerMap.substring(0, lowerMap.length() - 1);
        lowerMap += "]\n";
        String map = upperMap + lowerMap;
        result.setResultMap(map);
        return map;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Result result) {
        String resultMap = result.getResultMap();
        String successOrFailure = result.getSuccessOrFailure();
        int numberOfTrials = result.getNumberOfTrials();
        MessageUtil.gameResultMsg(resultMap, successOrFailure, numberOfTrials);
    }
}
