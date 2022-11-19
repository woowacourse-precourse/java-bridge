package bridge.validator;

import bridge.constant.ErrorConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameRetryOrEndCommandValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "U", "D", "R1", "QQ"})
    void 다시_시도_또는_종료_커맨드가_R_또는_Q가_아니면_예외_발생(String gameRetryOrEndCommand) {
        GameRetryOrEndCommandValidator gameRetryOrEndCommandValidator = new GameRetryOrEndCommandValidator();

        assertThatThrownBy(() -> gameRetryOrEndCommandValidator.validate(gameRetryOrEndCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstant.ERROR_PREFIX)
                .hasMessageContaining("게임을 다시 시작할지 여부는 R또는 Q여야합니다.");
    }
}