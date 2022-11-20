package bridge.view;

import bridge.constant.Constant;

import java.util.List;

public class OutputView {

    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";

    public static void printStartGame() {
        System.out.println(START_BRIDGE_GAME);
    }

    public static void printMap(List<List<String>> map) {
        for (int i = 0; i < Constant.BRIDGE_WIDTH; i++) {
            System.out.println("[ " +String.join(" | ", map.get(i)) + " ]");
        }
    }

    public static void printResult() {
    }
}
