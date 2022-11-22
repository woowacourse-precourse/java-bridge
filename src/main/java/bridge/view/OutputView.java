package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.map.BridgeMap;
import bridge.domain.map.BridgeMark;
import java.util.List;

import static bridge.view.OutputConstants.*;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    public static void printMap(BridgeMap map) {
        System.out.println(convertToString(map));
        System.out.println();
    }

    private static String convertToString(BridgeMap map) {
        List<BridgeMark> up = map.getUp();
        List<BridgeMark> down = map.getDown();
        return lineToString(up) + LINE_SEPARATOR + lineToString(down);
    }

    private static String lineToString(List<BridgeMark> line) {
        StringBuilder sb = new StringBuilder();
        for (BridgeMark mapSymbol : line) {
            sb.append(mapSymbol.getMark());
        }
        return sb.toString().replaceFirst(DELIMITER, BLANK);
    }

    public static void printResult(BridgeGame game) {

        System.out.println(GAME_RESULT_MESSAGE);
        printMap(game.getMap());
        System.out.println(String.format(SUCCESS_OR_FAILURE, isSuccess(game.isPlayerAlive())));
        System.out.println(String.format(TRIAL_COUNT_MESSAGE, game.getTrialCount()));
    }

    private static String isSuccess(boolean isAlive) {
        if (isAlive) {
            return SUCCESS;
        }
        return FAILURE;
    }


}