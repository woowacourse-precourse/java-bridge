package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private Bridge bridge;
    private GameResult gameResult;
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(5);
        gameResult = new GameResult();
        bridgeGame = new BridgeGame();
    }

    @DisplayName("다리를 이동하기 위한 입력이 U, D 이외의 값 이외일때 예외가 발생한다.")
    @Test
    void inputMoveShapeExceptionTest() {
        assertThatThrownBy(() -> new BridgeGame().move(bridge.getShape().get(0), "O"))
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

    @DisplayName("다리모양에 맞는 인풋을 넣었을때 제대로 gameResult 에 세팅이 되는지 테스트.")
    @Test
    void successMovingTest() {
        bridgeGame.initGameResult();
        gameResult = bridgeGame.move("U", "U");
        assertThat(gameResult.getUpBridgeResult().get(0)).isEqualTo("O");
        assertThat(gameResult.getDownBridgeResult().get(0)).isEqualTo(" ");
    }

    @DisplayName("다리모양과 틀린 인풋을 넣었을때 제대로 gameResult 에 세팅이 되는지 테스트.")
    @Test
    void failMovingTest() {
        bridgeGame.initGameResult();
        gameResult = bridgeGame.move("D", "U");
        assertThat(gameResult.getUpBridgeResult().get(0)).isEqualTo("X");
        assertThat(gameResult.getDownBridgeResult().get(0)).isEqualTo(" ");
    }

    @DisplayName("재시작 인풋에 대한 플래그를 잘 리턴하는지 테스트")
    @CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
    @ParameterizedTest
    void inputRetryOrEndFlagTest(String element, boolean expected) {
        assertThat(new BridgeGame().retry(element))
                .isEqualTo(expected);
    }
}