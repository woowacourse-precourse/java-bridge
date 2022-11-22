package bridge.view;

import bridge.domain.BridgeResult;
import bridge.domain.GameStatus;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_DELIMITER = " | ";
    private final String BRIDGE_PREFIX = "[ ";
    private final String BRIDGE_SUFFIX = " ]";
    private final String RESULT_MESSAGE = "\n최종 게임 결과";
    private final String RESULT_GAME_STATUS_MESSAGE = "\n게임 성공 여부: %s";
    private final String RESULT_GAME_TRY_COUNT_MESSAGE = "\n총 시도한 횟수: %d";
    private final String ERROR_PREFIX = "[ERROR] %s";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeResult bridgeResult) {
        printBridge(bridgeResult.getUpBridge());
        printBridge(bridgeResult.getDownBridge());
    }

    private void printBridge(List<String> bridge) {
        System.out.println(bridge.stream()
                .collect(Collectors.joining(BRIDGE_DELIMITER, BRIDGE_PREFIX, BRIDGE_SUFFIX)));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeResult bridgeResult, GameStatus gameStatus, int tryCount) {
        System.out.println(RESULT_MESSAGE);
        printMap(bridgeResult);
        System.out.printf(RESULT_GAME_STATUS_MESSAGE, gameStatus.getMessage());
        System.out.printf(RESULT_GAME_TRY_COUNT_MESSAGE, tryCount);
    }

    public void printError(String message) {
        System.out.printf(ERROR_PREFIX, message);
    }
}
