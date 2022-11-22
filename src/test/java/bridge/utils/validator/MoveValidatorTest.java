package bridge.utils.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveValidatorTest {

    @DisplayName("입력받은 이동이 U와 D가 아니면 예외를 발생시킨다.")
    @ValueSource(strings = {"30", "UP", "DOWN!"})
    @ParameterizedTest
    void createMoveByNotUPandDOWN(String input) {
        assertThatThrownBy(() -> new MoveValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
