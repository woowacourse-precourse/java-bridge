package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private Bridge bridge;
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(5);
        gameResult = new GameResult();
    }

    @DisplayName("다리를 이동하기 위한 입력이 U, D 이외의 값 이외일때 예외가 발생한다.")
    @Test
    void inputMoveShapeExceptionTest() {
        assertThatThrownBy(() -> new BridgeGame().move(bridge.getShape(), "O"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("재시작 여부에 대한 입력이 R또는 Q가 아닐 경우 예외가 발생한다.")
    @Test
    void inputRetryExceptionTest() {
        assertThatThrownBy(() -> new BridgeGame().retry("K"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void movingResultTest() {
        BridgeGame bridgeGame = new BridgeGame();
        gameResult = bridgeGame.move(bridge.getShape(), "U");
        assertThat(gameResult.getUpBridgeResult())
                .contains("O");
    }

    @CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
    @ParameterizedTest
    void inputRetryOrEndFlagTest(String element, boolean expected) {
        assertThat(new BridgeGame().retry(element))
                .isEqualTo(expected);
    }
}