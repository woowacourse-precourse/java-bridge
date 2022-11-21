package bridge.domain;

import static bridge.constant.Const.*;

public class GameProgress {

    public static StringBuilder map() {
        StringBuilder map = new StringBuilder();
        map.append(stateUpOrDownInBridge(UP)).append("\n").append(stateUpOrDownInBridge(DOWN)).append("\n");
        return map;
    }

    public static StringBuilder result(BridgeGameHost bridgeGameHost) {
        StringBuilder result = new StringBuilder();
        result.append(lastMap()).append("\n");
        result.append(whetherFailOrSuccess(bridgeGameHost)).append("\n");
        result.append(numberOfRetry()).append("\n");
        return result;
    }

    private static StringBuilder stateUpOrDownInBridge(String position) {
        StringBuilder printOfMap = new StringBuilder();
        pastMap(printOfMap, position);
        nowMap(printOfMap, position);
        translateLastLetter(printOfMap);
        return printOfMap;
    }

    private static void pastMap(StringBuilder printOfMap, String position) {
        for (int index = 0; index < Player.getIndex(); index++) {
            if (Player.playerCanGo(index, position)) {
                printOfMap.append(VERTICAL_BAR).append(O);
            }

            if (!Player.playerCanGo(index, position)) {
                printOfMap.append(VERTICAL_BAR).append(BLANK);
            }
        }
    }

    private static void nowMap(StringBuilder printOfMap, String position) {
        if (Player.getAlive()) { // 플레이어가 살아있을 떄
            appendNowMapWhenAlive(printOfMap, position);
        }

        if (!Player.getAlive()) { // 플레이어가 죽었을 때
            appendNowMapWhenNotAlive(printOfMap, position);
        }
    }

    private static void appendNowMapWhenAlive(StringBuilder printOfMap, String position) {
        if (Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(O);
        }

        if (!Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(BLANK);
        }
    }

    private static void appendNowMapWhenNotAlive(StringBuilder printOfMap, String position) {
        if (Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(O);
        }

        if (!Player.playerCanGo(Player.getIndex(), position)) {
            printOfMap.append(VERTICAL_BAR).append(X);
        }
    }

    private static void translateLastLetter(StringBuilder printOfMap) {
        printOfMap.setCharAt(0, LEFT_SQUARE_BRACKET);
        printOfMap.append(RIGHT_SQUARE_BRACKET);
    }

    private static String lastMap() {
        return GAME_RESULT + "\n" + map();
    }

    private static String whetherFailOrSuccess(BridgeGameHost bridgeGameHost) {
        return GAME_SUCCESS + bridgeGameHost.getResult() + "\n";
    }

    private static String numberOfRetry() {
        return NUMBER_OF_RETRY + Player.getNumberOfRetry() + "\n";
    }
}
