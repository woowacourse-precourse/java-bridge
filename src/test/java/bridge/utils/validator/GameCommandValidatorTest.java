package bridge.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCommandValidatorTest {

    @DisplayName("입력받은 이동이 R와 Q가 아니면 예외를 발생시킨다.")
    @ValueSource(strings = {"Retry", "Quit", "GO!"})
    @ParameterizedTest
    void createGameCommadbyNotRorQ(String input) {
        assertThatThrownBy(() -> new GameCommandValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
