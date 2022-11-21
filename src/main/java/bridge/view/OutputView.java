package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.OneSideResults;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. 1. OutputView의 패키지는 변경할 수 🌴있다.🌴 2. OutputView의 메서드의 이름은 변경할 수 🌴없고🌴, 인자와 반환 타입은
 * 필요에 따라 추가하거나 변경할 수 🌴있다.🌴 3. 값 출력을 위해 필요한 메서드를 추가할 수 🌴있다.🌴
 */
public class OutputView {

    private final static String BRIDGE_HEAD = "[";
    private final static String BRIDGE_TAIL = "]";
    private final static String BLANK_SPACE = " ";
    private final static String BRIDGE_PARTITION = "|";
    private final static String FINAL_RESULT_TITLE = "최종 게임 결과";
    private final static String SUCCESS_OR_FAILURE_TITLE = "게임 성공 여부: %s";
    private final static String TOTAL_TRIAL_COUNT_TITLE = "총 시도한 횟수: ";
    private final static String GAME_START_TITLE = "다리 건너기 게임을 시작합니다.";

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
        addResults(oneSideMap, oneSideResults);
        oneSideMap.add(BRIDGE_TAIL);
    }

    private static void addResults(StringJoiner oneSideMap, OneSideResults oneSideResults) {
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
        System.out.println(String.format(SUCCESS_OR_FAILURE_TITLE, finalResult));
    }

    public static void printTotalTrialCount(int totalTrialCount) {
        System.out.println(TOTAL_TRIAL_COUNT_TITLE + totalTrialCount);
    }
}
