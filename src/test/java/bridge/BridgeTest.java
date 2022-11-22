package bridge;

import bridge.domain.Bridge;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge();
        bridge.registerBridge(List.of("U", "D", "U", "U"));
    }

    @DisplayName("칸에 해당하는 다리 방향에따라 갈 수 있을 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"U:0", "D:1", "U:2", "U:3"}, delimiter = ':')
    void isMatchBothIndexAndStringTest(String bridgeSide, int index) {
        assertThat(bridge.isMatchBothIndexAndString(bridgeSide, index)).isTrue();
    }

    @DisplayName("칸에 해당하는 다리 방향에따라 갈 수 없을 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"D:0", "U:1", "D:2", "D:3"}, delimiter = ':')
    void isNotMatchBothIndexAndStringTest(String bridgeSide, int index) {
        assertThat(bridge.isMatchBothIndexAndString(bridgeSide, index)).isFalse();
    }

    @DisplayName("마지막 칸인지 확인하는 테스트")
    @Test
    void isLastCountTest() {
        assertThat(bridge.isLastCount(bridge.getBridge().size() - 1)).isTrue();
    }

    @DisplayName("마지막 칸이 아닐경우 확인하는 테스트")
    @Test
    void isNotLastCountTest() {
        assertThat(bridge.isLastCount(2)).isFalse();
    }


}
