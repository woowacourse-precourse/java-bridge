package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("숫자가 아니면 예외가 발생한다.")
    @Test
    void notNumber() {
        assertThatThrownBy(() -> Validator.isNumber("안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 숫자 3보다 작으면 예외가 발생한다.")
    @Test
    void underRange() {
        assertThatThrownBy(() -> Validator.checkSizeRange(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최고 숫자 20보다 크면 예외가 발생한다.")
    @Test
    void overRange() {
        assertThatThrownBy(() -> Validator.checkSizeRange(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 방향이 U와 D가 아니면 예외가 발생한다.")
    @Test
    void notDirection() {
        assertThatThrownBy(() -> Validator.checkMovingDirection("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
