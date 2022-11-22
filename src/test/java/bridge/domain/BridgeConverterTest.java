package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeConverterTest {
    @Test
    void 랜덤값_0을_D로_변환한다() {
        String convertedValue = BridgeConverter.convert(0);

        Assertions.assertThat(convertedValue).isEqualTo("D");
    }

    @Test
    void 랜덤값_1을_U로_변환한다() {
        String convertedValue = BridgeConverter.convert(1);

        Assertions.assertThat(convertedValue).isEqualTo("U");
    }
}