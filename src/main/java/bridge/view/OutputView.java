package bridge.view;

import bridge.constant.Constant;

import java.util.List;

public class OutputView {

    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String RESULT_OF_GAME = "최종 게임 결과";
    private static final String RESULT_OF_SUCCESS_OR_FAIL= "게임 성공 여부: %s\n";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: %d";

    public static void printStartGame() {
        System.out.println(START_BRIDGE_GAME);
    }

    public static void printMap(List<List<String>> map) {
        for (int i = 0; i < Constant.BRIDGE_WIDTH; i++) {
            System.out.println("[ " +String.join(" | ", map.get(i)) + " ]");
        }
    }

    public static void printResult(List<List<String>> map, String result, int totalTry) {
        System.out.println(RESULT_OF_GAME);
        printMap(map);
        System.out.printf((RESULT_OF_SUCCESS_OR_FAIL), result);
        System.out.printf((TOTAL_TRY_COUNT), totalTry);
    }
}
