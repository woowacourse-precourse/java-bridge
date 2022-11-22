package bridge.validation;

import bridge.util.message.ErrorMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RestartAndQuickValidTest {

    private static Validation validation;

    @BeforeAll
    public static void init() {
        validation = new RestartQuickValidation();
    }

    @Test
    void 재시작_확인_테스트() {
        // given
        String move = "R";

        // when, then
        validation.validate(move);
    }

    @Test
    void 종료_확인_테스트() {
        // given
        String move = "Q";

        // when, then
        validation.validate(move);
    }

    @Test
    void 재시작_종료_숫자_예외_테스트() {
        // given
        String size = "4";

        // when, then
        assertThatThrownBy(() -> validation.validate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_RESTART_QUICK_VALID_STRING.getMessage());
    }

    @Test
    void 재시작_종료_문자_예외_테스트() {
        // given
        String size = "RQ";

        // when, then
        assertThatThrownBy(() -> validation.validate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_RESTART_QUICK_VALID_STRING.getMessage());
    }
}
