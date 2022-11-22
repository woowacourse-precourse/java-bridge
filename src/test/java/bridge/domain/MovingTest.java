package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovingTest {
    @DisplayName("아무것도 입력하지 않은 경우")
    @Test
    void validateNullInput() {
        final String inputMoving = "";
        assertThatThrownBy(() -> Moving.createMoving(inputMoving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다시 입력해주세요.");
    }

    @DisplayName("U나 D가 아닌 문자를 입력할 경우")
    @ValueSource(strings = {"R", "-", "5", "-3", "-U", "DD", " U"})
    @ParameterizedTest
    void validateUpOrDown(String inputMoving) {
        assertThatThrownBy(() -> Moving.createMoving(inputMoving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] U(위), 혹은 D(아래)를 입력해주세요.");
    }
}
