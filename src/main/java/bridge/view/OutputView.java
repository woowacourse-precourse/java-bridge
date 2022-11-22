package bridge.view;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeMap;
import bridge.model.Constants;

import java.util.List;

public class OutputView {

    public static void start() {
        System.out.println(GameMessage.GAME_START.getMessage());
        System.out.println();
    }

    public static void askLength() {
        System.out.println(GameMessage.ASK_BRIDGE_SIZE.getMessage());
    }

    public static void askMove() {
        System.out.println();
        System.out.println(GameMessage.ASK_MOVE.getMessage());
    }

    public static void askRestart() {
        System.out.println();
        System.out.println(GameMessage.ASK_RESTART.getMessage());
    }

    public static void printMap(List<String> way, List<String> realWay) {
        String up = drawMap(way, realWay, Constants.UP);
        String down = drawMap(way, realWay, Constants.DOWN);
        System.out.println(up);
        System.out.println(down);
    }

    private static String drawMap(List<String> way, List<String> realWay, String position) {
        StringBuilder sb = new StringBuilder(BridgeMap.BEGIN.getSign());
        for (int i = 0; i < way.size(); i++) {
            appendDelimiter(sb, i);
            if (!way.get(i).equals(position)) {
                sb.append(BridgeMap.NONE.getSign());
                continue;
            }
            sb.append(determineOX(way, realWay, i));
        }
        return sb.append(BridgeMap.END.getSign()).toString();
    }

    private static void appendDelimiter(StringBuilder sb, int i) {
        if (i != 0) {
            sb.append(BridgeMap.DELIMITER.getSign());
        }
    }

    private static String determineOX(List<String> way, List<String> realWay, int i) {
        if (way.get(i).equals(realWay.get(i))) {
            return BridgeMap.ABLE.getSign();
        }
        return BridgeMap.DISABLE.getSign();
    }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println();
        System.out.println(GameMessage.FINAL_RESULT.getMessage());
        printMap(bridgeGame.getPlayer().getWay(), bridgeGame.getBridge().getBridge());
        System.out.println();
        System.out.printf(GameMessage.SHOW_RESULT.getMessage(), bridgeGame.getResult());
        System.out.printf(GameMessage.SHOW_TRIES.getMessage(), bridgeGame.getPlayer().getTries());
    }
}
