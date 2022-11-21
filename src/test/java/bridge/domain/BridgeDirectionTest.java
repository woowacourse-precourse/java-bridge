package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeDirectionTest {
    @ParameterizedTest
    @CsvSource(value = {"0: DOWN", "1: UP"}, delimiter = ':')
    void getDirection_올바른_값_반환(int number, BridgeDirection bridgeDirection) {
        assertThat(BridgeDirection.getDirection(number)).isEqualTo(bridgeDirection);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1: ERROR", "2: ERROR", "10: ERROR"}, delimiter = ':')
    void getDirection_올바르지_않은_값_ERROR_반환(int number, BridgeDirection bridgeDirection) {
        assertThat(BridgeDirection.getDirection(number)).isEqualTo(bridgeDirection);
    }
}