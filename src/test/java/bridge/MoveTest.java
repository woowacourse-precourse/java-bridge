package bridge;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveTest {

    @Test
    @DisplayName("Move 객체 생성 테스트")
    void createMoveTest() {
        Move move = Move.from("U");
        assertThat(move).isEqualTo(Move.UP);
    }

    @Test
    @DisplayName("Move 객체 생성 테스트")
    void createMoveTest2() {
        Move move = Move.from("D");
        assertThat(move).isEqualTo(Move.DOWN);
    }

    @Test
    @DisplayName("toString 테스트")
    void toStringTest() {
        assertThat(Move.from("U")).hasToString("U");
    }
}
