package bridge;

import bridge.domain.BridgeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {
    private BridgeMap bridgeMap;

    @BeforeEach
    void setUp() {
        bridgeMap = new BridgeMap();
    }

    @DisplayName("이동한 칸이 맞을 경우 `O` 아닐경우 `X`를 추가하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:[ O ]:[   ]", "false:[ X ]:[   ]"}, delimiter = ':')
    void addUpperBridgeMapTest(boolean isMatch, String result, String space) {
        bridgeMap.addUpperBridge(isMatch);

        assertThat(bridgeMap.getUpperBridgeToString()).isEqualTo(result);
        assertThat(bridgeMap.getLowerBridgeToString()).isEqualTo(space);
    }

    @DisplayName("이동한 칸이 맞을 경우 `O` 아닐경우 `X`를 추가하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:[ O | O ]:[   |   ]", "false:[ X | X ]:[   |   ]"}, delimiter = ':')
    void addLowerBridgeMapTest(boolean isMatch, String result, String space) {
        bridgeMap.addLowerBridge(isMatch);
        bridgeMap.addLowerBridge(isMatch);

        assertThat(bridgeMap.getLowerBridgeToString()).isEqualTo(result);
        assertThat(bridgeMap.getUpperBridgeToString()).isEqualTo(space);
    }
}
