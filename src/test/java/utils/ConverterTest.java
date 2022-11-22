package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    private static final int RANDOM_LOWER = 0;
    private static final int RANDOM_UPPER = 1;

    @DisplayName("랜덤 생성 숫자 1을 U로 변환한다.")
    @Test
    void convertRandomNumberOntToUpperBridge() {
        String bridge = Converter.convertNumberToBridgeUpOrDown(RANDOM_UPPER);

        assertThat(bridge).isEqualTo(ConstValue.UPPER_BRIDGE);
    }

    @DisplayName("랜덤 생성 숫자 0을 D로 변환한다.")
    @Test
    void convertRandomNumberZeroToLowerBridge() {
        String bridge = Converter.convertNumberToBridgeUpOrDown(RANDOM_LOWER);

        assertThat(bridge).isEqualTo(ConstValue.LOWER_BRIDGE);
    }
}
