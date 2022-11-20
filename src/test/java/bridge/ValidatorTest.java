package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("3이상 20이하의 숫자를 입력하지 않으면 예외가 발생한다")
    @Test
    void bridgeSizeValidation(){
        assertThatThrownBy(() -> Validator.size("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U 또는 D 문자를 입력하지 않으면 예외가 발생한다")
    @Test
    void directionValidation(){
        assertThatThrownBy(() -> Validator.direction("Q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R 또는 Q 문자를 입력하지 않으면 예외가 발생한다")
    @Test
    void retryCommandValidation(){
        assertThatThrownBy(() -> Validator.retryCommand("I"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
