package bridge.view;

import bridge.domain.BridgeGameResult;

import java.util.List;

import static bridge.utils.MessageFormat.*;
import static bridge.utils.ViewMessages.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_UP_SIDE_SHAPE = "U";
    private static final String BRIDGE_DOWN_SIDE_SHAPE = "D";

    public void printGameStart() {
        System.out.println(GAME_START);
        printNewLine();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGameResult bridgeGameResult) {
        System.out.println(printBridgeByShape(bridgeGameResult, BRIDGE_UP_SIDE_SHAPE));
        System.out.println(printBridgeByShape(bridgeGameResult, BRIDGE_DOWN_SIDE_SHAPE));
    }

    private String printBridgeByShape(BridgeGameResult bridgeGameResult, String shape) {
        List<String> bridge = bridgeGameResult.getBridgeByShape(shape);
        String bridgeElements = String.join(" " + BRIDGE_SPACE_DIVISION + " ", bridge);
        return BRIDGE_START +  bridgeElements + BRIDGE_END;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameResult bridgeGameResult) {
        System.out.println(GAME_RESULT);
        printMap(bridgeGameResult);
        System.out.println(bridgeGameResult.isSuccess());
        System.out.println(GAME_COUNT + bridgeGameResult.getCount());
    }

    public void printNewLine() {
        System.out.println();
    }
}
