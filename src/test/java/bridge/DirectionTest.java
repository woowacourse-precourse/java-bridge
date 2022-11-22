package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DirectionTest {
    @DisplayName("문자열에서 Direction 객체 생성 테스트")
    @Test
    public void getDirectionFromStringTest() {
        assertThat(Direction.getDirection("U")).isEqualTo(Direction.UP);
        assertThat(Direction.getDirection("D")).isEqualTo(Direction.DOWN);
    }

    @DisplayName("문자열에서 Direction 객체 생성 예외 테스트")
    @Test
    public void getDirectionFromStringExceptionTest() {
        assertThatThrownBy(() -> Direction.getDirection("LEFT"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자에서 Direction 객체 생성 테스트")
    @Test
    public void getDirectionFromNumberTest() {
        assertThat(Direction.getDirection(0)).isEqualTo(Direction.DOWN);
        assertThat(Direction.getDirection(1)).isEqualTo(Direction.UP);
    }

    @DisplayName("숫자에서 Direction 객체 생성 예외 테스트")
    @Test
    public void getDirectionFromNumberExceptionTest() {
        assertThatThrownBy(() -> Direction.getDirection(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 리스트에서 Direction 객체 리스트 생성 테스트")
    @Test
    public void getDirectionListFromStringListTest() {
        assertThat(Direction.getDirections(List.of("U", "D")))
                .isEqualTo(List.of(Direction.UP, Direction.DOWN));
    }
}
