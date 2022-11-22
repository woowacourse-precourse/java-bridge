package bridge;

import java.util.List;
import java.util.Objects;

public class CrossBridge {

    public CrossBridge(int bridgeSize, List<String> bridgeShape) {
        crossBridge(bridgeSize, bridgeShape);
    }

    public static void crossBridge(int bridgeSize, List<String> bridgeShape) {
        int i = 0;
        while (i < bridgeSize) {
            String selectMove = InputView.readMoving();
            String aliveOrDie = BridgeGame.move(selectMove, bridgeShape);
            if (Objects.equals(aliveOrDie, "END")) {
                UpDown.BridgeGameState(selectMove, "FAIL");
                OutputView.printMap();
                break;
            }
            UpDown.BridgeGameState(selectMove, "PASS");
            if (i < bridgeSize - 1) {
                OutputView.printMap();
            }
            i++;
        }
    }
}
