package bridge.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {
    @ParameterizedTest(name = "{0}를 GameCommand로 변환하려 하면 예외를 던진다.")
    @ValueSource(strings = {"r","q"," ","","R1"," Q"})
    void toGameCommand_인자_형식이_잘못되면_예외_던지는_기능(String format) {
        assertThatThrownBy(() -> {
            GameCommand.toGameCommand(format);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "{0}를 GameCommand로 변환하면 {1}")
    @CsvSource({"R,R","Q,Q"})
    void toGameCommand_문자열을_GameCommmand로_변환하는_기능(String format, GameCommand expected) {
        assertThat(GameCommand.toGameCommand(format)).isEqualTo(expected);
    }
}