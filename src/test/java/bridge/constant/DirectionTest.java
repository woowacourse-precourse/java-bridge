package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"U=UPPER", "D=LOWER"}, delimiter = '=')
    void 문자열로_방향을_찾을_수_있다(String direction, Direction expected) {
        assertThat(Direction.from(direction)).hasValue(expected);
    }
}
