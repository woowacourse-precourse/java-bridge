package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.model.MoveBox;
import bridge.model.RestartStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartStatusTest {


    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void RestartStatusTest(String input) {
        assertThat(new RestartStatus(input).getRestart()).isEqualTo(input);
    }

    @ValueSource(strings = {"UD", "DD", "x", "1"})
    @ParameterizedTest
    void RestartStatusTest_예외_테스트(String input) {
        assertThatThrownBy(() -> new RestartStatus(input)).isInstanceOf(IllegalArgumentException.class);
    }
}