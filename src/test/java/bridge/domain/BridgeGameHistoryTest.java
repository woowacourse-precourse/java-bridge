package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BridgeGameHistoryTest {

    private BridgeGameHistory bridgeGameHistory;

    @BeforeEach
    void setUp() {
        bridgeGameHistory =
                BridgeGameHistory.of(new BridgePlayer(), new BridgeAnswer(), new BridgeGameRound());
    }

    @Test
    @DisplayName("다리 게임 기록을 생성 메서드 호출시 다리 게임 기록 생성에 성공한다.")
    void whenCreateBridgeGameHistoryThenSuccessTest() {
        assertThat(bridgeGameHistory).isNotNull();
    }

    @Test
    @DisplayName("플레이어 다리 기록을 불러오는 것에 성공한다.")
    void whenGetPlayerBridgeThenSuccessTest() {
        assertThat(bridgeGameHistory.getPlayerBridge()).isNotNull();
    }

    @Test
    @DisplayName("다리 정답 기록을 불러오는 것에 성공한다.")
    void whenGetBridgeAnswerThenSuccessTest() {
        assertThat(bridgeGameHistory.getBridgeAnswer()).isNotNull();
    }

    @Test
    @DisplayName("다리 게임 라운드 수를 불러오는 것에 성공한다.")
    void whenGetBridgeGameRoundThenSuccessTest() {
        assertThat(bridgeGameHistory.getBridgeGameRound()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("비어있는 다리 게임 결과를 불러오는 것에 실패하여 예외처리 한다.")
    void whenGetGameResultEmptyThenExceptionTest() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> bridgeGameHistory.getGameResult());
    }
}