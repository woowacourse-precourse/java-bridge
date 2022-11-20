package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    @BeforeEach
    public void beforeEach() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        PassingSpace passingSpace = new PassingSpace();
        bridgeGame = new BridgeGame(bridge, passingSpace);
    }

    @DisplayName("사용자가 움직인 공간을 그려준다.")
    @Test
    void drawPassingSpaceAfterOneMoving() {
        String result = "[ O | X ]\n" +
                "[   |   ]\n";
        bridgeGame.move("U");
        bridgeGame.move("U");
        String passingSpace = bridgeGame.drawPassingSpace();

        Assertions.assertThat(passingSpace).isEqualTo(result);
    }

    @DisplayName("사용자가 움직인 공간을 그려준다.")
    @Test
    void drawPassingSpaceAfterTwoMoving() {
        String result = "[ O ]\n[   ]\n";
        bridgeGame.move("U");
        bridgeGame.move("D");
        String passingSpace = bridgeGame.drawPassingSpace();

        Assertions.assertThat(passingSpace).isEqualTo(result);
    }

    @Test
    void judgeSuccessMoving() {
    }

    @Test
    void retry() {
    }

    @Test
    void isSuccessCrossingBridge() {
    }

    @Test
    void getNumberOfTry() {
    }

    @Test
    void isRightSpace() {
    }
}