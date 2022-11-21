package bridge;

import bridge.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @DisplayName("숫자를 방향으로 변환")
    @Test
    void 숫자_방향_테스트() {
        int number1 = 0;
        assertThat(Direction.from(number1)).isEqualTo(Direction.D);
        int number2 = 1;
        assertThat(Direction.from(number2)).isEqualTo(Direction.U);
    }

    @DisplayName("문자를 방향으로 변환")
    @Test
    void 문자_방향_테스트() {
        String direction1 = "D";
        assertThat(Direction.from(direction1)).isEqualTo(Direction.D);
        String direction2 = "U";
        assertThat(Direction.from(direction2)).isEqualTo(Direction.U);
    }
}
