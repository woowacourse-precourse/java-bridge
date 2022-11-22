package bridge;

import bridge.Validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGenerateTest {

    @DisplayName("다리 생성 숫자는 0 또는 1이어야 합니다")
    @Test
    void 다리_길이_LOWER_테스트() {
        String bridgeLength = "2";
        assertThatThrownBy(() -> Validator.validateBridgeRandomNum(2)).isInstanceOf(
            IllegalArgumentException.class);
    }

}
