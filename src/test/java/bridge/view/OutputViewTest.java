package bridge.view;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    @Test
    void 중간_결과_출력_테스트() {
        OutputView outputView = new OutputView();
        Bridge bridge = new Bridge(List.of("D","U","D"));
        BridgeGame bridgeGame = new BridgeGame();
        for (int i = 0; i < 3; i++) {
            bridgeGame.move("D",bridge.getBridgeSpaces().get(i));
        }
        outputView.printMap(bridge);
    }

}