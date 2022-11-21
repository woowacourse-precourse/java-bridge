package bridge.domain;

import static bridge.constant.Const.*;

public class GameProgress {

    public static StringBuilder map() {
        StringBuilder map = new StringBuilder();
        map.append(upOrDownStepStateInBridge(UP)).append("\n")
                .append(upOrDownStepStateInBridge(DOWN)).append("\n");
        return map;
    }

    public static StringBuilder result() {
        StringBuilder result = new StringBuilder();
        result.append(lastMap()).append("\n");
        result.append(whetherFailOrSuccess());
        result.append(numberOfRetry());
        return result;
    }

    private static StringBuilder upOrDownStepStateInBridge(String position) {
        StringBuilder printOfMap = new StringBuilder();
        passedStepState(printOfMap, position);
        nowStepState(printOfMap, position);
        convertLastLetter(printOfMap);
        return printOfMap;
    }

    private static void passedStepState(StringBuilder printOfMap, String position) {
        for (int index = 0; index < Player.getIndex(); index++) {
            if (Player.playerCanGo(index, position)) {
                printOfMap.append(VERTICAL_BAR).append(O);
            }

            if (!Player.playerCanGo(index, position)) {
                printOfMap.append(VERTICAL_BAR).append(BLANK);
            }
        }
    }

    private static void nowStepState(StringBuilder printOfMap, String position) {
        if (Player.getAlive()) { // 플레이어가 살아있을 떄
            stepStateWhenPlayerIsAlive(printOfMap, position);
        }

        if (!Player.getAlive()) { // 플레이어가 죽었을 때
            stepStateWhenPlayerIsNotAlive(printOfMap, position);
        }
    }

    private static void stepStateWhenPlayerIsAlive(StringBuilder printOfMap, String position) {
        if (Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(O);
        }

        if (!Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(BLANK);
        }
    }

    private static void stepStateWhenPlayerIsNotAlive(StringBuilder printOfMap, String position) {
        if (Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(BLANK);
        }

        if (!Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(X);
        }
    }

    private static void convertLastLetter(StringBuilder printOfMap) {
        printOfMap.setCharAt(0, LEFT_SQUARE_BRACKET);
        printOfMap.append(RIGHT_SQUARE_BRACKET);
    }

    private static String lastMap() {
        return GAME_RESULT + "\n" + map();
    }

    private static String whetherFailOrSuccess() {
        return GAME_SUCCESS + BridgeGameHost.getResult() + "\n";
    }

    private static String numberOfRetry() {
        return NUMBER_OF_RETRY + Player.getNumberOfRetry() + "\n";
    }
}
