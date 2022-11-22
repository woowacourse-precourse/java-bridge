package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMapperTest {

    @DisplayName("0을 넣으면 D를 반환한다.")
    @Test
    void convertZeroToD() {
        String result = BridgeMapper.convertBridgeNumberToBridgeString(0);
        assertThat("D").isEqualTo(result);
    }

    @DisplayName("1을 넣으면 U를 반환한다.")
    @Test
    void convertOneToU() {
        String result = BridgeMapper.convertBridgeNumberToBridgeString(1);
        assertThat("U").isEqualTo(result);
    }
}
