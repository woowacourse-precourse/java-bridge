package bridge.domain;

import bridge.constant.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class MovementTest {

    @DisplayName("canMove 메서드는 움직일 수 있다면 true를, 없다면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    void canMoveTest(String input, boolean expected) {
        Bridge bridge = new Bridge(List.of("U"));
        Movement movement = new Movement(bridge);
        movement.saveMoving(new Moving(input));
        Assertions.assertThat(movement.canMove()).isEqualTo(expected);
    }

    @DisplayName("사용자가 모두 정답을 입력하면 게임은 성공으로 종료된다.")
    @Test
    void isSuccessFinishTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        Movement movement = new Movement(bridge);
        movement.saveMoving(new Moving("U"));
        movement.saveMoving(new Moving("D"));
        movement.saveMoving(new Moving("D"));
        Assertions.assertThat(movement.isSuccess()).isEqualTo(Constant.SUCCESS);
    }


    @DisplayName("사용자가 끝까지 정답을 입력했지만, 마지막 움직임이 실패하면 실패한다.")
    @Test
    void isFailureFinishTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        Movement movement = new Movement(bridge);
        movement.saveMoving(new Moving("U"));
        movement.saveMoving(new Moving("D"));
        movement.saveMoving(new Moving("U"));
        Assertions.assertThat(movement.isSuccess()).isEqualTo(Constant.FAILURE);
    }
}