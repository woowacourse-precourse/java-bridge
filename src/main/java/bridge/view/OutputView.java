package bridge.view;

import static bridge.util.Constants.BLANK_SPACE;

import bridge.domain.BridgeGame;
import bridge.domain.OneSideResults;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class OutputView {

    private static final String BRIDGE_HEAD = "[";
    private static final String BRIDGE_TAIL = "]";
    private static final String BRIDGE_PARTITION = "|";

    private static final String FINAL_RESULT_TITLE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE_TITLE = "게임 성공 여부: ";
    private static final String TOTAL_TRIAL_COUNT_TITLE = "총 시도한 횟수: ";
    private static final String GAME_START_TITLE = "다리 건너기 게임을 시작합니다.";

    public static void printGameStart() {
        System.out.println(GAME_START_TITLE);
        System.out.println();
    }

    public static void printMap(BridgeGame bridgeGame) {
        final StringJoiner upsideMap = new StringJoiner(BLANK_SPACE);
        final StringJoiner downsideMap = new StringJoiner(BLANK_SPACE);
        updateMap(upsideMap, bridgeGame.getUpsideResults());
        updateMap(downsideMap, bridgeGame.getDownsideResults());

        System.out.println(upsideMap);
        System.out.println(downsideMap);
        System.out.println();
    }

    private static void updateMap(StringJoiner oneSideMap, OneSideResults oneSideResults) {
        oneSideMap.add(BRIDGE_HEAD);
        addOneSideResults(oneSideMap, oneSideResults);
        oneSideMap.add(BRIDGE_TAIL);
    }

    private static void addOneSideResults(StringJoiner oneSideMap, OneSideResults oneSideResults) {
        final List<String> results = oneSideResults.getResults();
        final int startNumberInclusive = 0;
        final int endNumberExclusive = results.size();

        IntStream.range(startNumberInclusive, endNumberExclusive).forEach(index -> {
            oneSideMap.add(results.get(index));
            addPartition(index, results, oneSideMap);
        });
    }

    private static void addPartition(
            int index,
            List<String> results,
            StringJoiner oneSideMap
    ) {
        if (hasMoreThanTwoElements(results) && isNotLastIndex(index, results)) {
            oneSideMap.add(BRIDGE_PARTITION);
        }
    }

    private static boolean hasMoreThanTwoElements(List<String> results) {
        return results.size() >= 2;
    }

    private static boolean isNotLastIndex(int index, List<String> results) {
        return index != results.size() - 1;
    }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(FINAL_RESULT_TITLE);
        printMap(bridgeGame);
        printSuccessOrFailure(bridgeGame.getFinalResult());
        printTotalTrialCount(bridgeGame.getTotalTrialCount());
    }

    private static void printSuccessOrFailure(String finalResult) {
        System.out.println(SUCCESS_OR_FAILURE_TITLE + finalResult);
    }

    private static void printTotalTrialCount(int totalTrialCount) {
        System.out.println(TOTAL_TRIAL_COUNT_TITLE + totalTrialCount);
    }
}
