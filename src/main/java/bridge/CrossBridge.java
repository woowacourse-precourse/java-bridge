package bridge;

import java.util.List;
import java.util.Objects;

public class CrossBridge {

    static final String PASS = "PASS";
    static final String FAIL = "FAIL";

    public CrossBridge(int bridgeSize, List<String> bridgeShape) {
        crossBridge(bridgeSize, bridgeShape);
    }

    public static void crossBridge(int bridgeSize, List<String> bridgeShape) {
        int i = 0;
        while (i < bridgeSize) {
            String selectMove = InputView.readMoving();
            String aliveOrDie = BridgeGame.move(selectMove, bridgeShape);
            if (Objects.equals(aliveOrDie, BridgeGame.END)) {
                UpDown.BridgeGameState(selectMove, FAIL);
                OutputView.printMap();
                break;
            }
            UpDown.BridgeGameState(selectMove, PASS);
            OutputView.printMap();
            i++;
        }
        i = 0;
    }
}
