package bridge.domain;

import bridge.domain.MoveDirection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveDirectionTest {

    @DisplayName("사용자가 입력한 이동 방향이 U또는 D가 아닐 경우 예외를 던지는지 테스트")
    @Test
    void createMoveDirectionByWrongInput() {
        //given
        String direction = "C";
        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                      new MoveDirection(direction);
                  })
                  .isInstanceOf(IllegalArgumentException.class);
    }
}