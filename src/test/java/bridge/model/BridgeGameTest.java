package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("사용자가 재시작을 선택한다.")
    @ParameterizedTest
    @CsvSource({"R, true", "Q, false"})
    void selectRetrying(String selectRetrying, boolean result) {
        boolean isRetrying = bridgeGame.retry(selectRetrying);

        Assertions.assertThat(isRetrying).isEqualTo(result);
    }

    @DisplayName("다리를 건너는데 실패했다..")
    @Test
    void isFailureCrossingBridge() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        boolean isSuccessCrossing = bridgeGame.isSuccessCrossingBridge();

        Assertions.assertThat(isSuccessCrossing).isFalse();
    }

    @DisplayName("다리를 건너는데 성공했다.")
    @Test
    void isSuccessCrossingBridge() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        boolean isSuccessCrossing = bridgeGame.isSuccessCrossingBridge();

        Assertions.assertThat(isSuccessCrossing).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"U, true", "D, false"})
    void isRightSpace(String selectMoving, boolean isRight) {
        bridgeGame.move(selectMoving);

        boolean isRightSpace = bridgeGame.isRightSpace();

        Assertions.assertThat(isRightSpace).isEqualTo(isRight);
    }
}