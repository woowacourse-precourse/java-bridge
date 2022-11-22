package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {
    Validation validation = new Validation();

    @Test
    @DisplayName("다리 길이 범위 검증")
    void bridgeSizeValidation_fault1() {
        Assertions.assertThatThrownBy(() ->
                        validation.validationNumber(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 길이 범위 검증")
    void bridgeSizeValidation_fault2() {
        Assertions.assertThatThrownBy(() ->
                        validation.validationNumber(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("위 아래 움직임 값 검증")
    void movingValueValidation_fault1() {
        Assertions.assertThatThrownBy(() ->
                        validation.validationMoving("Q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 종료 및 재시행 값 검증")
    void movingValueValidation_fault2() {
        Assertions.assertThatThrownBy(() ->
                        validation.validationIsExitCommand("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
