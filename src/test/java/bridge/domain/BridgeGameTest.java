package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.move("U", "U");
        bridgeGame.move("F", "F");
        bridgeGame.move("U", "U");
    }

    @DisplayName("이동 성공 테스트")
    @Test
    void moveSuccess() {
        assertThat(bridgeGame.isMovingFail()).isFalse();
    }

    @DisplayName("이동 실패 테스트")
    @Test
    void moveFail() {
        bridgeGame.move("F", "U");
        assertThat(bridgeGame.isMovingFail()).isTrue();
    }

    @DisplayName("재시도 시 총 시도한 횟수가 증가하는 지 확인 테스트")
    @Test
    void increaseTotalAttemptsWhenRetry() {
        assertThat(bridgeGame.getTotalAttempts()).isEqualTo(1);
        bridgeGame.retry();
        assertThat(bridgeGame.getTotalAttempts()).isEqualTo(2);
    }

    @DisplayName("이동 기록 찾기 테스트")
    @ParameterizedTest
    @CsvSource({"0, U", "1, F", "2, U"})
    void findMovingByIndexTest(int index, String moving) {
        assertThat(bridgeGame.findMovingByIndex(index)).isEqualTo(moving);
    }

    @DisplayName("이동 결과 찾기 테스트")
    @ParameterizedTest
    @CsvSource({"0, true", "1, true", "2, true", "3, false"})
    void findMovingResultByIndexTest(int index, boolean result) {
        bridgeGame.move("F", "U");
        assertThat(bridgeGame.findMovingResultByIndex(index)).isEqualTo(result);
    }

    @DisplayName("이동 횟수 가져오기 테스트")
    @Test
    void getMovingCountTest() {
        assertThat(bridgeGame.getMovingCount()).isEqualTo(3);
    }
}