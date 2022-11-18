package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandExceptionTest {

    @DisplayName("입력이 R이나 Q가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} gameCommand : {0}")
    @ValueSource(strings = {"r", "q", "가나다", "test", "!@#"})
    void gameCommandIsNotRorQ(String gameCommand) {
        assertThatThrownBy(() -> GameCommandException.validate(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
