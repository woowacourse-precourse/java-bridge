package bridge.domain.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeStatusTest {

    @ParameterizedTest(name = "[{index}] input {0} ")
    @CsvSource(value = {"1, U", "0, D"})
    void Normal_Test(int input, String value) {
        Assertions.assertThat(BridgeStatus.makerValueToMovingValue(input)).isEqualTo(value);
    }
}