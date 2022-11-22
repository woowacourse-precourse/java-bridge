package bridge.view;

import bridge.service.BridgeGame;

import static bridge.utils.message.GameMessage.*;

public class OutputView {

    public void printInit() {
        System.out.println(OUTPUT_INIT_GAME);
    }

    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getResultMap());
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(OUTPUT_GAME_RESULT);
        printMap(bridgeGame);
        System.out.printf("%s %s\n", OUTPUT_SUCCESS_OR_FAIL, bridgeGame.getStatus());
        System.out.printf("%s %d\n", OUTPUT_TRY_COUNT, bridgeGame.getTryCount());
    }
    
}
