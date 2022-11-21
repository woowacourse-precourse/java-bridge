package bridge.repository;

import static bridge.domain.enums.BlockStatus.DOWN;
import static bridge.domain.enums.BlockStatus.UP;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Blocks;
import bridge.domain.Bridge;
import bridge.domain.CrossStatuses;
import bridge.domain.enums.CrossStatus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameRepositoryTest {
    private final BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();

    @DisplayName("저장소에 다리 저장 성공 테스트")
    @Test
    void storeBridge_success() {
        // given
        Blocks blocks = new Blocks(List.of(UP, DOWN, UP, UP));
        CrossStatuses crossStatuses = new CrossStatuses(CrossStatus.createInitializationStatuses(4));
        // whaen
        Bridge bridge = new Bridge(blocks, crossStatuses);
        bridgeGameRepository.storeBridge(bridge);
        Bridge findBridge = bridgeGameRepository.findBridge();
        // then
        assertThat(bridge).isEqualTo(findBridge);
    }
}