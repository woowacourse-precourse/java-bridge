package bridge.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeComponentTest {

    @DisplayName("0 일때 문자열 D 반환")
    @Test
    void findByNumber0() {
        String result = BridgeComponent.findByNumber(0);
        Assertions.assertThat(result).isEqualTo("D");
    }

    @DisplayName("1 일때 문자열 U 반환")
    @Test
    void findByNumber1() {
        String result = BridgeComponent.findByNumber(1);
        Assertions.assertThat(result).isEqualTo("U");
    }
}