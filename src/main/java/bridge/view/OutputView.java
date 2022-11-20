package bridge.view;

import java.util.List;
import java.util.Collections;

import bridge.domain.Movement;
import bridge.domain.Player;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(int trialNumber, Player player) {
        String upperMap = "[";
        String lowerMap = "[";
        for (int i = 0; i < trialNumber+1; i++) {
            upperMap += isUpperMap(i, player);
            lowerMap += isLowerMap(i, player);
        }
        String map = setMapForPrint(upperMap, lowerMap);
        player.result = map;
        System.out.println(map);
    }

    private static String isUpperMap(int index, Player player) {
        List<Movement> route = player.getRoute();
        if (route.get(index).getDirection().equals("U")) {
            return isTrueOrFalse(index, player);
        }
        return "   |";
    }

    private static String isLowerMap(int index, Player player) {
        List<Movement> route = player.getRoute();
        if (route.get(index).getDirection().equals("D")) {
            return isTrueOrFalse(index, player);
        }
        return "   |";
    }

    private static String isTrueOrFalse(int index, Player player) {
        List<Boolean> answer = player.getAnswer();
        if (answer.get(index).equals(Boolean.TRUE)) {
            return " O |";
        }
        return " X |";
    }

    private static String setMapForPrint(String upperMap, String lowerMap) {
        upperMap = upperMap.substring(0, upperMap.length() - 1);
        upperMap += "]\n";
        lowerMap = lowerMap.substring(0, lowerMap.length() - 1);
        lowerMap += "]";
        return upperMap+lowerMap;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int trialNumber, Player player) {
        System.out.println("최종 결과다 짜과");
        printMap(trialNumber, player);
    }
}
