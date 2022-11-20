package bridge.view;

import static bridge.view.Message.*;

import bridge.UserBridge;
import bridge.service.BridgeGameService;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START = "[ ";
    private static final String DELIMITER = " | ";
    private static final String END = " ]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(UserBridge userBridge) {
        printBridge(userBridge.getUpBridge());
        printBridge(userBridge.getDownBridge());
        System.out.println();
    }

    private static void printBridge(List<String> bridge) {
        System.out.println(START + String.join(DELIMITER, bridge) + END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameService bridgeGameService, boolean success) {
        System.out.println(RESULT_MESSAGE);
        printMap(bridgeGameService.getUserBridge());
        if (!success) {
            System.out.println(FAIL_MESSAGE);
        }
        if (success) {
            System.out.println(SUCCESS_MESSAGE);
        }
        printCount(bridgeGameService.getCount());
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public void printMove() {
        System.out.println(MOVE_MESSAGE);
    }

    public void printCount(int count) {
        System.out.println(COUNT_MESSAGE + count);
    }

    public void printRetry() {
        System.out.println(RETRY_MESSAGE);
    }
}
