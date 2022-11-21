package bridge.view;

import bridge.core.BridgeGame;
import bridge.domain.Bridge;
import bridge.type.PassCondition;
import bridge.type.ProcessCondition;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static void printMap(ProcessCondition passCondition, BridgeGame bridgeGame) {
        Bridge bridge = bridgeGame.getBridge();
        Integer currentPosition = bridgeGame.getGameStatusOperator().getCurrentPosition();
        List<Integer> upIndexes = getPrintIndexes(bridge, currentPosition, "U");
        List<Integer> downIndexes = getPrintIndexes(bridge, currentPosition, "D");
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

    private static List<Integer> getPrintIndexes(Bridge bridge, Integer currentPosition, String bridgeBlockDirection) {
        List<String> passedBridgeMap = bridge.getBridgeMapUntil(currentPosition);
        List<Integer> printIndexes = IntStream.range(0, passedBridgeMap.size())
                .filter(idx -> passedBridgeMap.get(idx).equals(bridgeBlockDirection))
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
        System.out.print("[");
        for (int idx = 0; idx < currentPosition; idx++) {
            if (indexes.contains(idx)) {
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
    }

    private static void printCurrentBlockOrNot(Integer currentPosition, List<Integer> indexes) {
        if (indexes.contains(currentPosition)) {
            System.out.println(" O ]");
            return;
        }
        System.out.println("   ]");
    }

    private static void printFailedBlockOrNot(Integer currentPosition, List<Integer> indexes) {
        if (!indexes.contains(currentPosition)) {
            System.out.println(" X ]");
            return;
        }
        System.out.println("   ]");
    }
}
