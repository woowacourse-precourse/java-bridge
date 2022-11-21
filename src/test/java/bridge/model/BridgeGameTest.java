package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    Bridge bridge = new Bridge(List.of(Moving.U, Moving.U, Moving.D));
    BridgeGame bridgeGame = new BridgeGame(bridge);

    @BeforeEach
    void beforeEach() {
        bridgeGame.startGame();
    }

    @DisplayName("move 메서드는 player의 moving을 호출한다")
    @Test
    void move_메서드는_Moving을_받아_player의_move를_호출한다() {
        bridgeGame.move(Moving.D);
        assertThat(bridgeGame.isPlayerDead()).isTrue();
    }

    @DisplayName("retry를 하면 player는 초기화")
    @Test
    void retry_메서드는_player를_초기화시킨다() {
        // 플레이어를 DEAD 상태로 만들기
        bridgeGame.move(Moving.D);
        //플래이어 초기화 후 MOVING 상태로 변경
        bridgeGame.retry();
        assertThat(bridgeGame.isContinuing()).isTrue();
    }

    @DisplayName("retry를 두 번 하면 Trial 횟수는 3회")
    @Test
    void retry_메서드는_TrialCount를_증가시킨다() {
        bridgeGame.retry();
        bridgeGame.retry();
        assertThat(bridgeGame.getTrialCount()).isEqualTo(new TrialCount(3));
    }
}