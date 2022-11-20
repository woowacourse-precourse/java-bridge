package bridge.view;

import bridge.model.GameResultState;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SPACE = " ";
    private static final String SEPARATOR = "|";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String WIN_OR_LOSE_MESSAGE = "게임 성공 여부: %s" + LINE_SEPARATOR;
    private static final String TOTAL_TRIES_MESSAGE = "총 시도한 횟수: %d";

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

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(final GameResultState state, final int totalTries) {
        System.out.printf(WIN_OR_LOSE_MESSAGE, state.getMessage());
        System.out.printf(TOTAL_TRIES_MESSAGE, totalTries);
    }
}
