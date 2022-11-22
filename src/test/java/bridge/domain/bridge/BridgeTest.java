package bridge.domain.bridge;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class BridgeTest {
    private Bridge bridge;
    private Player player;

    @BeforeEach
    private void init() {
        BridgeNumberGenerator bridgeNumberGenerator = Mockito.mock(BridgeRandomNumberGenerator.class);
        when(bridgeNumberGenerator.generate()).thenReturn(0, 1, 0);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = Bridge.of(3, bridgeMaker);
        player = new Player();
    }

    @Test
    @DisplayName("유저가 선택한 곳이 이둥가능한 경우")
    void 다리_이동_가능_테스트() {
        player.addMoving("D");
        Assertions.assertThat(bridge.isMovable(player)).isTrue();
    }

    @Test
    @DisplayName("유저가 선택한 곳이 이둥 불가능한 경우")
    void 다리_이동_불가능_테스트() {
        player.addMoving("U");
        Assertions.assertThat(bridge.isMovable(player)).isFalse();
    }

    @Test
    @DisplayName("다리 생성 크기 확인 테스트")
    void 다리_크기_확인_테스트() {
        Assertions.assertThat(bridge.getBridgeSize()).isEqualTo(3);
    }
}
