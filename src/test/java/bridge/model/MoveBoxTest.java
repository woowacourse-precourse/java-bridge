package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveBoxTest {
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void MoveBox_테스트(String input) {
        assertThat(new MoveBox(input).getMovebox()).isEqualTo(input);
    }

    @ValueSource(strings = {"UD", "DD", "x", "1"})
    @ParameterizedTest
    void MoveBox_예외_테스트(String input) {
        assertThatThrownBy(() -> new MoveBox(input)).isInstanceOf(IllegalArgumentException.class);
    }
}