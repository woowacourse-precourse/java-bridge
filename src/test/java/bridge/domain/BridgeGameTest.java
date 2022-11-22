package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void createBridgeGame() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D"));
    }

    @DisplayName("생성된 다리 건널 수 있다면 True 테스트")
    @Test
    void 사용자_건널수있는값() {
        assertThat(bridgeGame.move("U")).isTrue();
    }

    @DisplayName("생성된 다리 건널 수 없다면 False 테스트")
    @Test
    void 사용자_건널수없는값() {
        assertThat(bridgeGame.move("D")).isFalse();
    }

    @DisplayName("게임을 다시 시도한다면 리스트 초기화 테스트")
    @Test
    void 게임_다시시작_리스트초기화_테스트() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        int gameListSize = bridgeGame.getUserGameList();

        bridgeGame.retry("R");
        int gameRestartListSize = bridgeGame.getUserGameList();

        assertThat(gameListSize).isNotEqualTo(gameRestartListSize);
    }

    @DisplayName("게임을 다시 시도한다면 시도 횟수 증가 테스트")
    @Test
    void 게임_다시시작_시도횟수_테스트() {
        bridgeGame.move("D");
        bridgeGame.retry("R");

        assertThat(bridgeGame.getNumberOfTry()).isEqualTo(2);
    }

    @DisplayName("게임 종료시 False 테스트")
    @Test
    void 게임_종료_테스트() {
        assertThat(bridgeGame.retry("Q")).isFalse();
    }
}