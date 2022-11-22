package bridge.view;

import bridge.core.BridgeGame;
import bridge.domain.Bridge;
import bridge.type.*;

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

    private static final String RESULT = "최종 게임 결과";
    private static final String FINISHED_OR_NOT_FINISHED = "게임 성공 여부: ";
    private static final String FINISHED = "성공";
    private static final String NOT_FINISHED = "실패";
    private static final String NUMBER_OF_TRY = "총 시도한 횟수: ";

    public static void printMap(ProcessCondition passCondition, BridgeGame bridgeGame) {
        Bridge bridge = bridgeGame.getBridge();
        Integer currentPosition = bridgeGame.getGameStatusOperator().getCurrentPosition();
        List<Integer> upIndexes = getPrintIndexes(bridge, currentPosition, BridgeBlock.UP);
        List<Integer> downIndexes = getPrintIndexes(bridge, currentPosition, BridgeBlock.DOWN);
        if (passCondition == PassCondition.PASS) printPass(currentPosition, upIndexes, downIndexes);
        if (passCondition == PassCondition.FAIL) printFail(currentPosition, upIndexes, downIndexes);
    }

    public static void printResult(ProcessCondition finishCondition, BridgeGame bridgeGame) {
        System.out.println();
        System.out.println(RESULT);
        if (finishCondition == FinishCondition.FINISHED) {
            printWhetherFinished(PassCondition.PASS, FINISHED, bridgeGame);
        }
        if (finishCondition == FinishCondition.NOT_FINISHED) {
            printWhetherFinished(PassCondition.FAIL, NOT_FINISHED, bridgeGame);
        }
        System.out.println(NUMBER_OF_TRY + bridgeGame.getGameStatusOperator().getNumberOfTry());
    }

    private static void printWhetherFinished(ProcessCondition passCondition,
                                             String finishCondition,
                                             BridgeGame bridgeGame) {
        printMap(passCondition, bridgeGame);
        System.out.println();
        System.out.println(FINISHED_OR_NOT_FINISHED + finishCondition);
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
