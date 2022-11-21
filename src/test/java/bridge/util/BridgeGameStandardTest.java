package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameStandardTest {
    private BridgeGameStandard bridgeGameStandard;

    @BeforeEach
    void setUp() {
        bridgeGameStandard = new BridgeGameStandard();
    }

    @DisplayName("범위를 벗어난 다리 길이에 대해 false를 반환한다.")
    @ValueSource(ints = { 2, 21, 0 })
    @ParameterizedTest
    void wrongBridgeSize(Integer input) {
        assertThat(bridgeGameStandard.isValidBridgeSize(input)).isEqualTo(false);
    }
}