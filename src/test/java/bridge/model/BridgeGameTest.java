package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @DisplayName("이동한 칸이 이동가능한 칸인지 확인")
    @Test
    void check_move() {
        BridgeGame bridgeGame = new BridgeGame(4, new BridgeFakeOneZeroLoopNumberGenerator());
        // BridgeFakeNumberGenerator (테스트용; 1,0,1,0 순환하면서 숫자생성) -> "U","D","U","D"순환
        assertThat(bridgeGame.move("D")).isFalse();
        assertThat(bridgeGame.move("U")).isFalse();
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("D")).isTrue();
    }

    @DisplayName("이동 완료 문의")
    @Test
    void is_completed_move() {
        BridgeGame bridgeGame = new BridgeGame(2, new BridgeFakeOneZeroLoopNumberGenerator());
        assertThat(bridgeGame.isCompletedGame()).isFalse();
        bridgeGame.move("D");
        assertThat(bridgeGame.isCompletedGame()).isFalse();
        bridgeGame.move("U");
        assertThat(bridgeGame.isCompletedGame()).isTrue();
    }

    @DisplayName("게임 다시 시도")
    @Test
    void test_retry() {
        BridgeGame bridgeGame = new BridgeGame(4, new BridgeFakeOneZeroLoopNumberGenerator());
        assertThat(bridgeGame.isStartStatus()).isTrue();
        bridgeGame.move("D");
        assertThat(bridgeGame.isCompletedGame()).isFalse();
        bridgeGame.retry();
        assertThat(bridgeGame.isStartStatus()).isTrue();
    }

}
