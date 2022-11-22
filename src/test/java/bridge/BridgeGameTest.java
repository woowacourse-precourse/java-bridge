package bridge;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static bridge.controller.BridgeController.upAndDown;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 입력값에_맞게_출력이_잘_되는지_test() {
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        upAndDown.add(up);
        upAndDown.add(down);
        bridgeGame.move(List.of("U", "U", "U"), 0, "U");
        assertThat(String.join("", upAndDown.get(0))).isEqualTo(" O |");
        assertThat(String.join("", upAndDown.get(1))).isEqualTo("   |");
    }


    @Test
    void 게임실패_test() {
        String result = bridgeGame.retry("Q");
        Assertions.assertEquals(result, "실패");
    }
}
