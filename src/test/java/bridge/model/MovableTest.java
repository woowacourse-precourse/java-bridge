package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MovableTest {

    @ParameterizedTest
    @CsvSource({"O, O", "X, X"})
    void getMark(Movable movable, String result) {
        String mark = movable.getMark();

        Assertions.assertThat(mark).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"O, true", "X, false"})
    void isMovable(Movable movable, boolean result) {
        boolean isMovable = movable.isMovable();

        Assertions.assertThat(isMovable).isEqualTo(result);
    }
}