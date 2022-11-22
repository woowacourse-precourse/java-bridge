package bridge.validator;

import bridge.constant.ErrorConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputNextStepValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "12", "A1", "U1", "DD"})
    void 입력한_이동할_칸_U_또는_D가_아니면_예외_처리(String inputNextStep) {
        InputNextStepValidator inputNextStepValidator = new InputNextStepValidator();

        assertThatThrownBy(() -> inputNextStepValidator.validate(inputNextStep))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstant.ERROR_PREFIX)
                .hasMessageContaining("이동할 칸은 U또는 D여야합니다.");
    }
}