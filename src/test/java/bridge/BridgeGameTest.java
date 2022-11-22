package bridge;

import bridge.domain.BridgeGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    BridgeGame bridgeGame;
    private final int bridgeSize = 3;

    @BeforeEach
    void createBridge() {
        assertRandomNumberInRangeTest(() -> {
            bridgeGame = new BridgeGame(bridgeSize);
        }, 1, 0, 1);

    }

    @DisplayName("다리를 건널 수 있는지 체크")
    @Test
    void checkCanCrossBridge() {
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("U")).isFalse();
    }

    @DisplayName("다리를 끝까지 건너면 성공")
    @Test
    void successWhenCrossBridgeAll() {
        bridgeGame.move("U");
        assertThat(bridgeGame.isSucess(bridgeSize)).isFalse();
        bridgeGame.move("D");
        assertThat(bridgeGame.isSucess(bridgeSize)).isFalse();
        bridgeGame.move("U");
        assertThat(bridgeGame.isSucess(bridgeSize)).isTrue();
    }

    @DisplayName("다리를 끝까지 건너지 못하면 실패")
    @Test
    void failWhenCantCrossBridgeAll() {
        bridgeGame.move("U");
        assertThat(bridgeGame.isSucess(bridgeSize)).isFalse();
        bridgeGame.move("D");
        assertThat(bridgeGame.isSucess(bridgeSize)).isFalse();
        bridgeGame.move("D");
        assertThat(bridgeGame.isSucess(bridgeSize)).isFalse();
    }

    @DisplayName("재시도하면 시도 횟수 증가")
    @Test
    void increaseTryCountWhenRetry() {
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }

    @DisplayName("재시도하면 현재 유저 상태 기록 초기화")
    @Test
    void initiateBridgeStatus() {
        bridgeGame.retry();
        assertThat(bridgeGame.getBridgeStatus().size()).isEqualTo(0);
    }

}
