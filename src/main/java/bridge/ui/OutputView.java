package bridge.ui;

import bridge.domain.BridgeMap;
import bridge.domain.BridgeStatus;
import bridge.domain.Result;

import java.util.Arrays;
import java.util.stream.Collectors;

import static bridge.domain.BridgeGameConstant.START_INDEX;
import static bridge.ui.ViewConstant.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeMap bridgeMap, int exposureBridgeBlockCount) {
        System.out.println(createBridgeView(bridgeMap, exposureBridgeBlockCount));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(result.getBridgeMap(), result.getBlockCount());
        System.out.println(GAME_SUCCESS_WHETHER_MESSAGE + result.getWinning());
        System.out.println(GAME_COUNT_MESSAGE + result.getGameCount());
    }

    public void printGameStartMessage() {
        System.out.println(GAME_INIT_MESSAGE);
    }

    public String createBridgeView(BridgeMap bridgeMap, int exposureBridgeBlockCount) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(bridgeMap.bridgeStatuses).forEach(row -> {
            sb.append(START_BRIDGE_SHAPE);
            sb.append(buildBridge(row, exposureBridgeBlockCount));
            sb.append(END_BRIDGE_SHAPE);
        });
        return sb.toString();
    }

    private String buildBridge(BridgeStatus[] row, int exposureBridgeBlockCount) {
        return Arrays.asList(row).subList(START_INDEX, exposureBridgeBlockCount)
                .stream()
                .map(bridgeBlockStatus -> bridgeBlockStatus.buildBridge)
                .collect(Collectors.joining(JOINING_DELIMITER));
    }
}
