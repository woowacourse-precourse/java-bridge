package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @DisplayName("정답을 반환하다")
    @ParameterizedTest(name = "position이 {0}이면 {1}일 때 정답을 반환한다")
    @CsvSource(value = {"0,UP", "1,DOWN", "2,DOWN"})
    void canMoveRightTest(int position, BridgeDirection direction) {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        Answer answer = bridge.canMove(position, direction);

        assertThat(answer).isEqualTo(Answer.RIGHT);
    }

    @DisplayName("오답을 반환하다")
    @ParameterizedTest(name = "position이 {0}이면 {1}일 때 오답을 반환한다")
    @CsvSource(value = {"0,UP", "1,DOWN", "2,DOWN"})
    void canMoveWrongTest(int position, BridgeDirection direction) {
        Bridge bridge = new Bridge(List.of("D", "U", "U"));
        Answer answer = bridge.canMove(position, direction);

        assertThat(answer).isEqualTo(Answer.WRONG);
    }
}