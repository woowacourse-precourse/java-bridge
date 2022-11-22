package bridge;


import bridge.domain.MoveResults;

import java.util.List;

public class OutputView {
    private static final String RESULT_GREETING = "최종 게임 결과";
    private static final String RESULT = "게임 성공 여부: ";
    private static final String TOTAl_TRY = "총 시도한 횟수: ";
    private static final String SQUARE_WALL = "|";
    private static final String ENTRANCE = "[";
    private static final String BRIDGE_EXIT = "]";

    public static void printMap(List<String> upMap, List<String> downMap) {
        System.out.println(ENTRANCE + map(upMap) + BRIDGE_EXIT);
        System.out.println(ENTRANCE + map(downMap)+ BRIDGE_EXIT);
    }

    public static void printEachMap(List<String> upMap, List<String> downMap) {
        System.out.println(ENTRANCE + map(upMap) + BRIDGE_EXIT);
        System.out.println(ENTRANCE + map(downMap)+ BRIDGE_EXIT);
    }

    public static void resultGreeting() {
        System.out.println(RESULT_GREETING);
    }

    public static void printResult(MoveResults moveResults) {
        System.out.println(RESULT + CrossResult.successFailureWord(moveResults.success()));
        System.out.println(TOTAl_TRY + moveResults.getTryNum());
    }

    public static String map(List<String> crossResults) {
        return String.join(",", crossResults).replace(",", SQUARE_WALL);
    }

}
