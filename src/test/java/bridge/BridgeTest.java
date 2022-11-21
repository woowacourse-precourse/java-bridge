package bridge;

import bridge.domain.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeTest {

    Bridge bridge;

    @DisplayName("이동이 가능여부 판단 기능 테스트")
    @Test
    void checkingMovableTest() {
        List<String> inputs = List.of("U", "D", "U");
        bridge = new Bridge(inputs);
        for (int i = 0; i < 3; i++) {
            boolean movableBlock = bridge.isMovableBlock(i, inputs.get(i));
            Assertions.assertThat(movableBlock).isTrue();
        }
    }

    @DisplayName("다리의 각 블록 중 유효하지 않은 값이 저장되면 오류가 발생함")
    @Test
    void insertInvalidBlocks() {
        List<String> movableBlocks = List.of("U", "F", "A");
        Assertions.assertThatThrownBy(() -> new Bridge(movableBlocks))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 문자가 포함되어 있습니다.");
    }

    @DisplayName("현재까지 건너온 다리 기록 조회 테스트")
    @Test
    void getCrossedBridgeTest() {
        List<String> inputs = List.of("U", "D", "U");
        Bridge bridge = new Bridge(inputs);

        List<String> crossedBridge = bridge.getCrossedBridge(1);
        Assertions.assertThat(crossedBridge).contains("U", "D");
    }
}
