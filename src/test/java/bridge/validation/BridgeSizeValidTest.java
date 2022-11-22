package bridge.validation;

import bridge.util.message.ErrorMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeValidTest {

    private static Validation validation;

    @BeforeAll
    public static void init() {
        validation = new BridgeSizeValidation();
    }

    @Test
    void 다리_크기_테스트() {
        // given
        String size = "10";

        // when, then
        validation.validate(size);
    }

    @Test
    void 다리_크기_범위_미만_예외_테스트() {
        // given
        String size = "2";

        // when, then
        assertThatThrownBy(() -> validation.validate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_RANGE_BRIDGE_SIZE.getMessage());
    }

    @Test
    void 다리_크기_범위_초과_예외_테스트() {
        // given
        String size = "21";

        // when, then
        assertThatThrownBy(() -> validation.validate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_RANGE_BRIDGE_SIZE.getMessage());
    }

    @Test
    void 다리_크기_문자_예외_테스트() {
        // given
        String size = "T";

        // when, then
        assertThatThrownBy(() -> validation.validate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_BRIDGE_SIZE.getMessage());
    }
}
