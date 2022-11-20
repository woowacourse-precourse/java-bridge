package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.dto.BridgeCrossingDTO;

public class BridgeGameTest {

    @Test
    void 이동한_위치_테스트() {
        // given
        List<String> bridgeTest = new ArrayList<>(List.of("U", "D", "D"));
        Bridge bridge = new Bridge(bridgeTest);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        BridgeCrossingDTO bridgeCrossingDTO = bridgeGame.toResponseDto();
        assertThat(bridgeCrossingDTO.getCrossStatus())
            .isEqualTo(BridgeCrossingStatus.PROGRESS.getStatus());
        assertThat(bridgeCrossingDTO.getTryCount())
            .isEqualTo(1);
    }

}
