package bridge.view;

import bridge.core.BridgeGame;
import bridge.domain.Bridge;
import bridge.type.BridgeBlock;
import bridge.type.PassCondition;
import bridge.type.ProcessCondition;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String DELIMITER = "|";
    private static final String CIRCLE_MARK = " O ";
    private static final String CROSS_MARK = " X ";
    private static final String SPACE = "   ";

    public static void printMap(ProcessCondition passCondition, BridgeGame bridgeGame) {
        Bridge bridge = bridgeGame.getBridge();
        Integer currentPosition = bridgeGame.getGameStatusOperator().getCurrentPosition();
        List<Integer> upIndexes = getPrintIndexes(bridge, currentPosition, BridgeBlock.UP);
        List<Integer> downIndexes = getPrintIndexes(bridge, currentPosition, BridgeBlock.DOWN);
        if (passCondition == PassCondition.PASS) printPass(currentPosition, upIndexes, downIndexes);
        if (passCondition == PassCondition.FAIL) printFail(currentPosition, upIndexes, downIndexes);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }

    private static List<Integer> getPrintIndexes(Bridge bridge, Integer currentPosition, BridgeBlock bridgeBlock) {
        List<String> passedBridgeMap = bridge.getBridgeMapUntil(currentPosition);
        List<Integer> printIndexes = IntStream.range(0, passedBridgeMap.size())
                .filter(idx -> passedBridgeMap.get(idx).equals(bridgeBlock.getBlockSymbol()))
                .boxed()
                .collect(Collectors.toList());
        return printIndexes;
    }

    private static void printPass(Integer currentPosition, List<Integer> upIndexes, List<Integer> downIndexes) {
        printCircle(currentPosition, upIndexes);
        printCircle(currentPosition, downIndexes);
    }

    private static void printFail(Integer currentPosition, List<Integer> upIndexes, List<Integer> downIndexes) {
        printCircleAndCross(currentPosition, upIndexes);
        printCircleAndCross(currentPosition, downIndexes);
    }

    private static void printCircle(Integer currentPosition, List<Integer> indexes) {
        printPreviousPath(currentPosition, indexes);
        printCurrentBlockOrNot(currentPosition, indexes);
    }

    private static void printCircleAndCross(Integer currentPosition, List<Integer> indexes) {
        printPreviousPath(currentPosition, indexes);
        printFailedBlockOrNot(currentPosition, indexes);
    }

    private static void printPreviousPath(Integer currentPosition, List<Integer> indexes) {
        System.out.print(OPEN_BRACKET);
        for (int idx = 0; idx < currentPosition; idx++) {
            if (indexes.contains(idx)) {
                System.out.print(CIRCLE_MARK + DELIMITER);
                continue;
            }
            System.out.print(SPACE + DELIMITER);
        }
    }

    private static void printCurrentBlockOrNot(Integer currentPosition, List<Integer> indexes) {
        if (indexes.contains(currentPosition)) {
            System.out.println(CIRCLE_MARK + CLOSE_BRACKET);
            return;
        }
        System.out.println(SPACE + CLOSE_BRACKET);
    }

    private static void printFailedBlockOrNot(Integer currentPosition, List<Integer> indexes) {
        if (indexes.contains(currentPosition)) {
            System.out.println(SPACE + CLOSE_BRACKET);
            return;
        }
        System.out.println(CROSS_MARK + CLOSE_BRACKET);

    }
}
