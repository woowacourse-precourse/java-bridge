package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 위치는_증가할_수_있다() {
        Position position = new Position();
        Position increasedPosition = position.increase();

        assertThat(increasedPosition.isGreaterOrEqualThan(0)).isTrue();
    }

    @Test
    void 음수인_위치는_예외를_던진다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1));
    }
}
