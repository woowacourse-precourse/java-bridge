package bridge.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeSizeValidatorTest {

    @Test
    void 다리_사이즈_범위_테스트() {
        assertThatThrownBy(() -> BridgeSizeValidator.runBridgeSizeValidator("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_사이즈_숫자_테스트() {
        assertThatThrownBy(() -> BridgeSizeValidator.runBridgeSizeValidator("안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}