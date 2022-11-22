package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"U=UPPER", "D=LOWER"}, delimiter = '=')
    void 문자열로_방향을_찾을_수_있다(String direction, Direction expected) {
        assertThat(Direction.from(direction)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=UPPER", "0=LOWER"}, delimiter = '=')
    void 숫자로_방향을_찾을_수_있다(int bridgeNumber, Direction expected) {
        assertThat(Direction.from(bridgeNumber)).isEqualTo(expected);
    }

    @Test
    void 잘못된_방향_문자열은_예외를_던진다() {
        String anomalyDirection = "ASDF";

        assertThatIllegalArgumentException().isThrownBy(() -> Direction.from(anomalyDirection));
    }

    @Test
    void 잘못된_숫자는_예외를_던진다() {
        int anomalyDirection = 2;

        assertThatIllegalArgumentException().isThrownBy(() -> Direction.from(anomalyDirection));
    }
}
