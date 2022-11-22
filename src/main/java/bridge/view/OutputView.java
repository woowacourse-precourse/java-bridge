package bridge.view;

import bridge.model.constants.GameMessage;

import java.util.List;

public class OutputView {

    public void printInit() {
        System.out.println(GameMessage.OUTPUT_INIT_GAME);
    }

    public void printMap(List<String> toStringBridges) {
        System.out.println(toStringBridges.get(0) + "\n" + toStringBridges.get(1) + "\n");
    }

    public void printResult(List<String> finalMap, String successOrFail, int triedNumber) {
        System.out.println(GameMessage.OUTPUT_GAME_RESULT);
        printMap(finalMap);

        System.out.println(GameMessage.OUTPUT_SUCCESS_OR_FAIL + successOrFail + "\n"
                            + GameMessage.OUTPUT_ATTEMPT_COUNT + triedNumber);
    }
}
