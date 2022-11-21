package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @DisplayName("숫자가 1이면 U 방향")
    @Test
    void createDirectionByNumberOne() {
        Direction direction = new Direction(1);
        String result = direction.getDirection();
        assertThat(result).isEqualTo("U");
    }

    @DisplayName("숫자가 0이면 D 방향")
    @Test
    void createDirectionByNumberZero() {
        Direction direction = new Direction(0);
        String result = direction.getDirection();
        assertThat(result).isEqualTo("D");
    }

    @DisplayName("숫자가 1과 0이 아니면 예외")
    @Test
    void createDirectionByNotNumberOneOrZero() {
        assertThatThrownBy(
                () -> new Direction(2)).isInstanceOf(IllegalArgumentException.class);
    }
}
