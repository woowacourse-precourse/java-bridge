package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_SEPARATOR = " | ";
    private static final String CORRECT_MARK = "O";
    private static final String WRONG_MARK = "X";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        GameMap gameMap = bridgeGame.getGameMap();
        System.out.println(BRIDGE_START + joinBySeparator(gameMap.getUpstairBridge()) + BRIDGE_END);
        System.out.println(BRIDGE_START + joinBySeparator(gameMap.getDownstairBridge()) + BRIDGE_END);
    }

    private String joinBySeparator(List<String> bridgeStatus) {
        return String.join(BRIDGE_SEPARATOR, bridgeStatus);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
