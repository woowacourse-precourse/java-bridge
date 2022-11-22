package bridge.view;

import static bridge.constant.OutputConstant.CHECK_CLEAR_FAIL;
import static bridge.constant.OutputConstant.FINAL_GAME_RESULT;
import static bridge.constant.OutputConstant.MAP_FINISHER;
import static bridge.constant.OutputConstant.MAP_SEPARATOR;
import static bridge.constant.OutputConstant.MAP_STARTER;
import static bridge.constant.OutputConstant.TOTAL_GAME_COUNT;

import bridge.type.GameStatusType;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

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
