package bridge.model;

import bridge.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveTest {
    @DisplayName("U나D 외의 입력이 왔을때 MOVE에서 예외가 발생함")
    @Test
    void createWrongMove() {
        assertThatThrownBy(() -> Move.createMove("O"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U나D가 왔을 때 해당하는 MOVE가 생성됨")
    @Test
    void createCorrectMove() {
        assertThat(Move.createMove("U")).isEqualTo(Move.U);
    }
}
