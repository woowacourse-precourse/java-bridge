package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @DisplayName("랜덤 생성 숫자 1을 U로 변환한다.")
    @Test
    void convertRandomNumberOntToUpperBridge() {
        int randomNumber = 1;
        String bridge = Converter.convertNumberToBridgeUpOrDown(randomNumber);

        assertThat(bridge).isEqualTo(ConstValue.UPPER_BRIDGE);
    }

    @DisplayName("랜덤 생성 숫자 0을 D로 변환한다.")
    @Test
    void convertRandomNumberZeroToLowerBridge() {
        int randomNumber = 0;
        String bridge = Converter.convertNumberToBridgeUpOrDown(randomNumber);

        assertThat(bridge).isEqualTo(ConstValue.LOWER_BRIDGE);
    }
}
