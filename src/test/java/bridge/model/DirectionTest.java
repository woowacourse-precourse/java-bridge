package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;
    private static final int STRANGE_NUMBER = 100;

    @DisplayName("난수가 1이면 위 방향으로 생성된다.")
    @Test
    void createByOne() {
        assertThat(Direction.from(RANDOM_UPPER_INCLUSIVE)).isEqualTo(Direction.U);
    }

    @DisplayName("난수가 0이면 아래 방향으로 생성된다.")
    @Test
    void createByZero() {
        assertThat(Direction.from(RANDOM_LOWER_INCLUSIVE)).isEqualTo(Direction.D);
    }

    @DisplayName("0과 1이외의 숫자로 생성하면 예외가 발생한다.")
    @Test
    void createByNotZeroAndOne() {
        assertThatThrownBy(() -> Direction.from(STRANGE_NUMBER)).isInstanceOf(IllegalArgumentException.class);
    }
}
