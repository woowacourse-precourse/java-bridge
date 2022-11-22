package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    @DisplayName("사용자가 게임을 재시도하면 시도 횟수가 증가하고, 재시도 플래그가 true로 설정된다.")
    void 게임_재시도_테스트() {
        //given
        BridgePlayer bridgePlayer = new BridgePlayer();
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "D"), bridgePlayer);

        //when
        bridgeGame.retry();

        //then
        assertThat(bridgeGame.getRetryStatus())
                .as("게임 재시도 시 재시도 플래그가 true로 설정된다.")
                .isEqualTo(true);

        assertThat(bridgePlayer.getTryCount())
                .as("게임 재시도 시 시도 횟수가 증가한다.")
                .isEqualTo(2);
    }
}