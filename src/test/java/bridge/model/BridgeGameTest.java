package bridge.model;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @ParameterizedTest
    @DisplayName("생성된 다리의 칸과 사용자의 입력값이 같을 때 참을 리턴하는지 테스트")
    @CsvSource({"U,U", "D,D"})
    void move_SameValue_True(String block, String currentMoving) {
        boolean result = bridgeGame.move(block, currentMoving);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("생성된 다리의 칸과 사용자의 입력값이 다를 때 거짓을 리턴하는지 테스트")
    @CsvSource({"U,D", "D,U"})
    void move_SameValue_False(String block, String currentMoving) {
        boolean result = bridgeGame.move(block, currentMoving);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("재시작 여부 입력 시 R을 입력한 경우 참을 리턴하는지 테스트")
    void retry_RestartCharacterAsTheParam_True() {
        boolean result = bridgeGame.retry("R");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("재시작 여부 입력 시 R이외의 값을 입력한 경우 거짓을 리턴하는지 테스트")
    void retry_QuitCharacterAsTheParam_True() {
        boolean result = bridgeGame.retry("Q");
        assertThat(result).isFalse();
    }
}