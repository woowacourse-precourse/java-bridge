package bridge;

import bridge.Validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeInputTest {

    @DisplayName("다리 길이는 3이상 20이하여야 한다.")
    @Test
    void 다리_길이_LOWER_테스트() {
        String bridgeLength = "2";
        assertThatThrownBy(() -> Validator.validateBridgeLength(bridgeLength)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("다리 길이는 3이상 20이하여야 한다.")
    @Test
    void 다리_길이_UPPER_테스트() {
        String bridgeLength = "21";
        assertThatThrownBy(() -> Validator.validateBridgeLength(bridgeLength)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("다리 길이는 정수여야 한다.")
    @Test
    void 다리_길이_정수_테스트() {
        String bridgeLength = "SS";
        assertThatThrownBy(() -> Validator.validateNumber(bridgeLength)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
