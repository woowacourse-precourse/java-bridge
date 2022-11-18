package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void before() {
        bridge = new Bridge(List.of("U", "D", "D"));
    }

    @DisplayName("정답을 반환하다")
    @ParameterizedTest(name = "position이 {0}이면 {1}일 때 정답을 반환한다")
    @CsvSource(value = {"0,UP", "1,DOWN", "2,DOWN"})
    void canMoveRightTest(int position, BridgeDirection direction) {
        Answer answer = bridge.canMove(position, direction);

        assertThat(answer).isEqualTo(Answer.RIGHT);
    }

    @DisplayName("오답을 반환하다")
    @ParameterizedTest(name = "position이 {0}이면 {1}일 때 오답을 반환한다")
    @CsvSource(value = {"0,DOWN", "1,UP", "2,UP"})
    void canMoveWrongTest(int position, BridgeDirection direction) {
        Answer answer = bridge.canMove(position, direction);

        assertThat(answer).isEqualTo(Answer.WRONG);
    }

    @DisplayName("다리 길이가 끝인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,true", "1,false"})
    void isEndTest(int position, boolean isEnd) {
        boolean result = bridge.isEnd(position);

        assertThat(result).isEqualTo(isEnd);
    }
}