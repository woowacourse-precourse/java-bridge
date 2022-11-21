package bridge.view;

import bridge.domain.BridgeState;
import bridge.domain.GameResult;
import bridge.domain.MoveResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_PARTITION = " | ";
    private static final String BRIDGE_BLANK = " ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        printRow(gameResult, BridgeState.UP);
        printRow(gameResult, BridgeState.DOWN);
    }

    public void printRow(GameResult gameResult, BridgeState bridgeState) {
        System.out.printf(BRIDGE_START);
        List<BridgeState> userStates = gameResult.getBridgeStates();
        for (int i = 0; i < userStates.size() - 1; i++) {
            printTile(MoveResult.SAME, userStates.get(i), bridgeState);
        }
        printTile(gameResult.getMoveResult(), userStates.get(userStates.size() - 1), bridgeState);
        System.out.printf(BRIDGE_END);
    }

    public void printTile(MoveResult moveResult, BridgeState userState, BridgeState bridgeState) {
        if (userState == bridgeState) {
            System.out.printf(moveResult.getResult());
            return;
        }
        System.out.printf(BRIDGE_BLANK + BRIDGE_PARTITION);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
