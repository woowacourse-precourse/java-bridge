package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {
    @DisplayName("다음 칸이 이동 가능한 칸인지 확인하는 테스트")
    @Test
    void 이동_가능한_칸_확인_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.isAvailableToMove("U", 0))
                .isTrue();
    }

    @DisplayName("칸 이동 확인 테스트")
    @Test
    void 칸_이동_확인_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
//        bridge.initializeCurrentPosition();
//        bridge.movePlayer();
//        bridge.movePlayer();
//        bridge.movePlayer();
//        assertThat(bridge.isLastBlock())
//                .isTrue();
    }
}
