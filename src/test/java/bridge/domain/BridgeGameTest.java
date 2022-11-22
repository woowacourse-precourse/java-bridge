package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
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

    @ParameterizedTest
    @ValueSource(strings = {"D,D,D,D,D", "U,D,D,U,D,U"})
    @DisplayName("사용자의 현재 위치가 다리의 끝에 도달하지 못했다면 true를, 도달했다면 false를 리턴해야 된다.")
    void 사용자_다리의_끝_검증_테스트(String input) {
        //given
        BridgePlayer bridgePlayer = new BridgePlayer();
        List<String> bridge = List.of("D", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge, bridgePlayer);

        // when
        Arrays.stream(input.split(","))
                .forEach(moveVal -> {
                    bridgePlayer.saveInputCommand(moveVal);
                    bridgeGame.move();
                });

        // then
        // 첫 번째 테스트 케이스에 대해서
        if (input.equals("D,D,D,D,D")) {
            assertThat(bridgeGame.isNotGameEnd())
                    .as("현재 위치가 다리의 끝에 도달하지 못했다면 게임이 진행 중이기 때문에 true를 리턴한다.")
                    .isEqualTo(true);
            return;
        }
        assertThat(bridgeGame.isNotGameEnd())
                .as("현재 위치가 다리의 끝에 도달했다면 게임이 종료되었기 때문에 false를 리턴한다.")
                .isEqualTo(false);
    }

}