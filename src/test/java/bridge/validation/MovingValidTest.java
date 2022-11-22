package bridge.validation;

import bridge.util.message.ErrorMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovingValidTest {

    private static Validation validation;

    @BeforeAll
    public static void init() {
        validation = new MovingValidation();
    }

    @Test
    void 위로_움직임_확인_테스트() {
        // given
        String move = "U";

        // when, then
        validation.validate(move);
    }

    @Test
    void 아래로_움직임_확인_테스트() {
        // given
        String move = "D";

        // when, then
        validation.validate(move);
    }

    @Test
    void 움직임_방향_숫자_예외_테스트() {
        // given
        String size = "4";

        // when, then
        assertThatThrownBy(() -> validation.validate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_MOVE_VALID_STRING.getMessage());
    }

    @Test
    void 움직임_방향_문자_예외_테스트() {
        // given
        String size = "UD";

        // when, then
        assertThatThrownBy(() -> validation.validate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_MOVE_VALID_STRING.getMessage());
    }
}
