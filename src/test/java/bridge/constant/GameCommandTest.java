package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCommandTest {

    @ParameterizedTest
    @CsvSource(value = {"R,RETRY", "Q,EXIT"}, delimiter = ',')
    void 문자열로_명령을_찾을_수_있다(String character, GameCommand expected) {
        assertThat(GameCommand.from(character)).isEqualTo(expected);
    }
}