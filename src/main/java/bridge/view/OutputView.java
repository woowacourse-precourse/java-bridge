package bridge.view;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_CONTENT = "[ %s ]%n";
    private final String BRIDGE_PLACE_CONTOUR = " | ";


    public void startPrint() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printBridgeLength(int length) {
        System.out.println(length);
    }

    public void printMap(LinkedHashMap<String, List<String>> bridgeMap) {
        for (List<String> map : bridgeMap.values()) {
            System.out.printf(BRIDGE_CONTENT, String.join(BRIDGE_PLACE_CONTOUR, map));
        }
    }



    public void printMoving(String moving) {
        System.out.println(moving);
    }

    public String printCommand(String command) {
        System.out.println(command);
        return command;
    }
}