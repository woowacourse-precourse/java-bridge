package bridge.status;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DirectionTest {

    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "a", "s", "d", "f", "A", "S", "F"})
    void Direction_에_포함되지_않는_방향이라면_false_리턴(String direction) {
        boolean result = Direction.contains(direction);

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void Direction_에_포함되는_방향이라면_true_리턴(String direction) {
        boolean result = Direction.contains(direction);

        assertThat(result).isTrue();
    }

    @Test
    void Direction_D_숫자를_문자로_반환() {
        String result = Direction.convert(0);

        assertThat(result).isEqualTo("D");
    }

    @Test
    void Direction_U_숫자를_문자로_반환() {
        String result = Direction.convert(1);

        assertThat(result).isEqualTo("U");
    }

}