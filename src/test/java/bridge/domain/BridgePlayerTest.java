package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgePlayerTest {

    @Test
    @DisplayName("사용자가 건널 수 있는 다리로 이동하면 현재 있는 위치가 증가하고 성공 플래그가 true로 설정된다.")
    void 사용자_건널_수_있는_다리_건너기_테스트() {
        //given
        BridgePlayer bridgePlayer = new BridgePlayer();
        List<String> bridge = List.of("U", "U", "D", "D");

        // when
        bridgePlayer.saveInputCommand("U");
        bridgePlayer.checkMove(bridge);

        // then
        assertThat(bridgePlayer.getCurrentBridgeSpace())
                .as("사용자가 현재 있는 다리의 칸은 0에서 1로 증가한다.")
                .isEqualTo(1);

        assertThat(bridgePlayer.isSuccess())
                .as("성공 플래그가 true로 설정된다.")
                .isEqualTo(true);
    }

    @Test
    @DisplayName("사용자가 건널 수 없는 다리로 이동하면 성공 플래그가 false로 설정된다.")
    void 사용자_건널_수_없는_다리_건너기_테스트() {
        //given
        BridgePlayer bridgePlayer = new BridgePlayer();
        List<String> bridge = List.of("U", "U", "D", "D");

        // when
        bridgePlayer.saveInputCommand("D");
        bridgePlayer.checkMove(bridge);

        // then
        assertThat(bridgePlayer.getCurrentBridgeSpace())
                .as("사용자가 현재 있는 다리의 칸은 증가하지 않는다.")
                .isEqualTo(0);

        assertThat(bridgePlayer.isSuccess())
                .as("성공 플래그가 false로 설정된다.")
                .isEqualTo(false);
    }
}