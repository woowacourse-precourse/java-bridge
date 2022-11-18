package bridge.domain.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMapTest {

    @DisplayName("Normal BridgeSize")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @CsvSource(value = {"1, U", "0, D"})
    void Validate_BridgeSize_exception(int input, String value) {
        Assertions.assertThat(BridgeMap.getMovingValue(input)).isEqualTo(value);
    }
}