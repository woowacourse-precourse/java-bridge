package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String SPACE = " ";
    public static final String SEPARATOR = "|";
    public static final String OPEN_BRACKET = "[";
    public static final String CLOSED_BRACKET = "]";

    public void printMap(final List<String> upBridges, final List<String> downBridges) {
        System.out.println(createBridgeMap(upBridges));
        System.out.println(createBridgeMap(downBridges));
    }

    private static String createBridgeMap(final List<String> bridges) {
        StringBuilder bridgeMap = new StringBuilder();
        createBridgeMap(bridges, bridgeMap);
        return bridgeMap.toString();
    }

    private static void createBridgeMap(final List<String> bridges, final StringBuilder bridgeMap) {
        bridgeMap.append(OPEN_BRACKET);
        for (int i = 0; i < bridges.size(); i++) {
            appendResult(bridgeMap, bridges.get(i));
            appendSeparatorIfCanContinue(bridges, bridgeMap, i);
        }
        bridgeMap.append(CLOSED_BRACKET);
    }

    private static void appendSeparatorIfCanContinue(
            final List<String> bridges,
            final StringBuilder bridgeMap,
            final int i
    ) {
        if (canContinue(bridges, i)) {
            bridgeMap.append(SEPARATOR);
        }
    }

    private static boolean canContinue(final List<String> bridges, final int i) {
        return i != bridges.size() - 1;
    }

    private static void appendResult(final StringBuilder bridgeMap, final String result) {
        bridgeMap.append(SPACE)
                .append(result)
                .append(SPACE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
