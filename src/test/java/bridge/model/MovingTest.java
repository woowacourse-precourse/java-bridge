package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MovingTest {
    @DisplayName("움직이는 값이 U 또는 D가 아닐시 예외가 발생한다.")
    @Test
    void createGivenNotUOrD() {
        assertThatThrownBy(() -> new Moving("NOT"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
