package bridge.view;

import bridge.type.GameStatusType;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String MAP_STARTER = "[ ";
    private static final String MAP_FINISHER = " ]";
    private static final String MAP_SEPARATOR = " | ";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String CHECK_CLEAR_FAIL = "게임 성공 여부: ";
    private static final String TOTAL_GAME_COUNT = "총 시도한 횟수: ";

    public void printMap(List<List<String>> playingMap) {
        for (List<String> playingBridge : playingMap) {
            System.out.println(toStringOf(playingBridge));
        }
        System.out.println();
    }

    public void printResult(List<List<String>> playingMap, GameStatusType gameStatusType, int gameCount) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(playingMap);
        System.out.println(CHECK_CLEAR_FAIL + gameStatusType.toString());
        System.out.println(TOTAL_GAME_COUNT + gameCount);
    }

    private String toStringOf(List<String> playingBridge) {
        StringJoiner stringJoiner = new StringJoiner(MAP_SEPARATOR, MAP_STARTER, MAP_FINISHER);
        for (String result : playingBridge) {
            stringJoiner.add(result);
        }
        return stringJoiner.toString();
    }
}
