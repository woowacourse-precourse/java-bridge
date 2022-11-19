package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private final BridgeStatusSaver bridgeStatusSaver = new BridgeStatusSaver();
    private final BridgeMaker bridgeMaker = mock(BridgeMaker.class);
    private final BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeStatusSaver);

    @DisplayName("다리 생성시 영속화 테스트")
    @Test
    void persistBridgeStatusWhenCreateBridge() {
        // given
        when(bridgeMaker.makeBridge(anyInt())).thenReturn(List.of("U", "D", "U"));

        // when
        bridgeGame.createBridge(3);

        // then
        assertThat(bridgeStatusSaver.getBridgeStatus()).isNotNull();
    }
}