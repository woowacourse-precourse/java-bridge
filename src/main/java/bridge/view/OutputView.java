package bridge.view;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_CONTAINER = "[ %s ]%n";
    private final String BRIDGE_CELL_CONTOUR = " | ";
    private final String FINAL_GAME_RESULT = "최종 게임 결과";
    private final String WHETHER_GAME_IS_SUCCESSFUL = "게임 성공 여부: %s";
    private final String GAME_SUCCESS = "성공";
    private final String GAME_LOSE = "실패";
    private final String RETRY_COUNT = "총 시도한 횟수: %d";

    public void gameStartPrint() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printBridgeSize(int bridgeSize) {
        System.out.println(bridgeSize);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(LinkedHashMap<String, List<String>> bridgeMap) {
        for (List<String> map : bridgeMap.values()) {
            System.out.printf(BRIDGE_CONTAINER, String.join(BRIDGE_CELL_CONTOUR, map));
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(LinkedHashMap<String, List<String>> bridgeMap, boolean isGame, int retry) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(bridgeMap);
        printIsGame(isGame);
        printRetryCount(retry);
    }

    private void printIsGame(boolean isGame) {
        if (isGame) {
            System.out.printf(WHETHER_GAME_IS_SUCCESSFUL, GAME_SUCCESS);
            return;
        }
        System.out.printf(WHETHER_GAME_IS_SUCCESSFUL, GAME_LOSE);
    }

    private void printRetryCount(int retry) {
        System.out.printf(RETRY_COUNT, retry);
    }

    public void printMoving(String moving) {
        System.out.println(moving);
    }

    public String printGameCommand(String gameCommand) {
        System.out.println(gameCommand);
        return gameCommand;
    }
}
