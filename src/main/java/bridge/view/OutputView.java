package bridge.view;


import java.util.List;

public class OutputView {


    private static final String SEPARATOR = " | ";
    private static final String BRIDGE_START_POINT = "[";
    private static final String BRIDGE_END_POINT = "]";
    private static final String TEMPLATE_GAME_STATUS_VIEW = "게임 성공 여부: %s \n";
    private static final String TEMPLATE_GAME_STATUS_SUCCESS = "성공";
    private static final String TEMPLATE_GAME_STATUS_FAILED = "실패";
    private static final String TEMPLATE_COUNT_ATTEMPTS_VIEW = "총 시도한 횟수: %d \n";

    public void printMap(List<List<String>> maps) {
        maps.forEach(map -> {
            System.out.printf("%s %s %s \n", BRIDGE_START_POINT, String.join(SEPARATOR, map), BRIDGE_END_POINT);
        });
    }

    public void printFinalMap(List<List<String>> maps) {
        System.out.println("\n최종 게임 결과");
        printMap(maps);
    }

    public void printResult(int attemptCount, boolean gameStatus) {
        System.out.printf(TEMPLATE_GAME_STATUS_VIEW, readStatus(gameStatus));
        System.out.printf(TEMPLATE_COUNT_ATTEMPTS_VIEW, attemptCount);
    }


    private String readStatus(boolean gameStatus) {
        if (gameStatus) {
            return TEMPLATE_GAME_STATUS_SUCCESS;
        }
        return TEMPLATE_GAME_STATUS_FAILED;
    }
}
