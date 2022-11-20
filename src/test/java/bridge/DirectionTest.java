package bridge;

import bridge.model.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("올바른 코드를 입력하여 방향에 대해 정보를 얻어올 때 정상 반환")
    @Test
    public void directionGetTest() {
        assertThat(Direction.of(0)).isEqualTo(Direction.DOWN);
        assertThat(Direction.of(1)).isEqualTo(Direction.UP);
    }

    @DisplayName("잘못된 코드를 입력하여 방향에 대한 정보를 얻어올 때 예외 처리")
    @Test
    public void wrongDirectionGetTest() {
        assertThatThrownBy(() -> Direction.of(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
