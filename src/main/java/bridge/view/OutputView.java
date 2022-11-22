package bridge.view;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_CONTENT = "[ %s ]%n";
    private final String BRIDGE_PLACE_CONTOUR = " | ";
    private final String GAME_RESULT = "최종 게임 결과";
    private final String IS_GAME_SUCCESSFUL = "게임 성공 여부: %s%n";
    private final String GAME_SUCCESS = "성공";
    private final String GAME_FAIL = "실패";
    private final String RETRY_COUNT = "총 시도한 횟수: %d";

    public void startPrint() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printBridgeLength(int length) {
        System.out.println(length);
    }

    public void printMap(LinkedHashMap<String, List<String>> bridgeMap) {
        for (List<String> map : bridgeMap.values()) {
            System.out.printf(BRIDGE_CONTENT, String.join(BRIDGE_PLACE_CONTOUR, map));
        }
    }

    private void printIsGame(boolean isGame) {
        if (isGame) {
            System.out.printf(IS_GAME_SUCCESSFUL, GAME_SUCCESS);
            return;
        }
        System.out.printf(IS_GAME_SUCCESSFUL, GAME_FAIL);
    }

    private void printRetryCount(int retry) {
        System.out.printf(RETRY_COUNT, retry);
    }

    public void printResult(LinkedHashMap<String, List<String>> bridgeMap, boolean isGame, int retryCount) {
        System.out.println(GAME_RESULT);
        printMap(bridgeMap);
        printIsGame(isGame);
        printRetryCount(retryCount);
    }

    public void printMoving(String moving) {
        System.out.println(moving);
    }

    public String printCommand(String command) {
        System.out.println(command);
        return command;
    }
}