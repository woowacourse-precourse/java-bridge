package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {
    private Bridge bridge;
    private List<String> testBlocks = List.of("U", "U", "D");

    @BeforeEach
    void setUp() {
        bridge = new Bridge(testBlocks);
    }

    @DisplayName("다리 길이를 구하는 테스트")
    @Test
    void getBridgeLengthTest() {
        assertThat(bridge.length()).isEqualTo(testBlocks.size());
    }

    @DisplayName("다리 한 칸 찾는 테스트")
    @Test
    void findBlockByIndexTest() {
        int index = 2;
        assertThat(bridge.findBlockByIndex(index)).isEqualTo(testBlocks.get(index));
    }
}