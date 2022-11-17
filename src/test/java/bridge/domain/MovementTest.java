package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class MovementTest {

    @DisplayName("canMove 메서드는 사용자가 정답을 입력하면 true를 오답을 입력하면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    void canMoveTest(String input, boolean expected) {
        Movement movement = new Movement(List.of("U"));
        boolean result = movement.canMove(new Moving(input));
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사용자가 모두 정답을 입력하면 게임은 종료된다.")
    @Test
    void isFinishTest() {
        Movement movement = new Movement(List.of("U", "D", "D"));
        movement.canMove(new Moving("U"));
        movement.canMove(new Moving("D"));
        movement.canMove(new Moving("D"));

        Assertions.assertThat(movement.isFinish()).isTrue();
    }
}