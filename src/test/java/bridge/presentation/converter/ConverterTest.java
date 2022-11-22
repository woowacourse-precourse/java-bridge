package bridge.presentation.converter;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @DisplayName("문자열 BridgeSize를 숫자 BridgeSize로 변경")
    @Test
    void 다리_길이_변환_테스트() {
        String size = "15";

        int bridgeSize = Converter.convertBridgeSize(size);

        assertThat(bridgeSize).isEqualTo(15);
    }

}