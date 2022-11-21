package bridge.view;

import bridge.OneSideResults;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 1. OutputView의 패키지는 변경할 수 🌴있다.🌴
 * 2. OutputView의 메서드의 이름은 변경할 수 🌴없고🌴, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 🌴있다.🌴
 * 3. 값 출력을 위해 필요한 메서드를 추가할 수 🌴있다.🌴
 */
public class OutputView {
    private final static String BRIDGE_HEAD = "[";
    private final static String BRIDGE_TAIL = "]";
    private final static String BLANK_SPACE = " ";
    private final static String BRIDGE_PARTITION = "|";
    private final static String GAME_RESULT = "최종 게임 결과";
    private final static String MISSION_COMPLETE_OR_NOT = "게임 성공 여부: %s";
    private final static String TOTAL_TRIAL_COUNT = "총 시도한 횟수: ";
    private final static String GAME_START = "다리 건너기 게임을 시작합니다.";

    public static void printGameStart() {
        System.out.println(GAME_START);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(OneSideResults upsideResults, OneSideResults downsideResults) {
        StringJoiner upsideMap = new StringJoiner(BLANK_SPACE);
        StringJoiner downsideMap = new StringJoiner(BLANK_SPACE);

        updateMap(upsideMap, upsideResults);
        updateMap(downsideMap, downsideResults);

        System.out.println(upsideMap);
        System.out.println(downsideMap);
    }

    private static void updateMap(StringJoiner oneSideMap, OneSideResults oneSideResults) {
        oneSideMap.add(BRIDGE_HEAD);
        addResults(oneSideMap, oneSideResults);
        oneSideMap.add(BRIDGE_TAIL);
    }

    private static void addResults(StringJoiner oneSideMap, OneSideResults oneSideResults) {
        List<String> results = oneSideResults.getResults();
        results.forEach(result -> {
                    oneSideMap.add(result);
                    if (isNotEmpty(results) && isNotLastIndex(result, results)) {
                        oneSideMap.add(BRIDGE_PARTITION);
                }
        });
    }

    private static boolean isNotEmpty(List<String> results) {
        return results.size() > 0;
    }

    private static boolean isNotLastIndex(String result, List<String> results) {
        return results.indexOf(result) != results.size() -1;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int stepCount, List<String> upSideResult, List<String> downSideResult, String gameResult) {
        System.out.println(GAME_RESULT);
        printMap(stepCount, upSideResult, downSideResult);
        System.out.println();
        System.out.println(String.format(MISSION_COMPLETE_OR_NOT, gameResult));
    }

    public static void printTotalTrialCount(int trialCount) {
        System.out.println(TOTAL_TRIAL_COUNT + trialCount);
    }
}
