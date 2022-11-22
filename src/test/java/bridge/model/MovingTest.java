package bridge.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingTest {

    @ParameterizedTest(name = "{0}를 Bridge로 변환하려 하면 예외를 던진다.")
    @ValueSource(strings = {"u","d"," ","","U1"," D"})
    void toBridge_인자_형식이_잘못되면_예외_던지는_기능(String format) {
        assertThatThrownBy(() -> {
            Moving.toMoving(format);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}를 Bridge로 변환하면 {1}")
    @CsvSource({"U,UP","D,DOWN"})
    void toBridge_문자열을_Bridge로_변환하는_기능(String format, Moving expected) {
        assertThat(Moving.toMoving(format)).isEqualTo(expected);
    }
}