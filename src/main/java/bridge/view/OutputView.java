package bridge.view;

import bridge.service.BridgeGame;
import bridge.service.Referee;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final int BRIDGE_COUNT = 2;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> myPaths, List<String> bridgePaths) {
        String[][] comparePath = Referee.makeComparePath(myPaths, bridgePaths);

        for (int i = 0; i < BRIDGE_COUNT; i++) {
            String compareOnePath = toStringWithPath(comparePath[i]);
            System.out.println(compareOnePath);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        String resultMessage = Referee.convertResult(bridgeGame.getMovePath(), bridgeGame.getBridge());
        int totalCount = bridgeGame.getTotalCount();

        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getMovePath(), bridgeGame.getBridge());
        System.out.println("게임 성공 여부: " + resultMessage);
        System.out.println("총 시도한 횟수: " + totalCount);

    }

    public String toStringWithPath(String[] compareOnePath) {
        StringBuilder formatMessage = new StringBuilder();

        formatMessage.append("[");
        for (int i = 0; i < compareOnePath.length; i++) {
            formatMessage.append(" " + compareOnePath[i] + " ");
            if (i < compareOnePath.length - 1) {
                formatMessage.append("|");
            }
        }
        formatMessage.append("]");

        return new String(formatMessage);
    }
}
