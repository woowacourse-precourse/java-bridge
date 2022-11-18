package bridge.util;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeInputConverterTest {
    @Test
    @DisplayName("다리 길이 convert 테스트")
    public void bridgeSizeConverterTest() {
        // given
        String input = "5";

        // when
        int result = BridgeInputConverter.bridgeSizeConverter(input);

        // then
        assertThat(result).isEqualTo(5);
    }
}
