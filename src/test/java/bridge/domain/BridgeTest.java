package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    private static final int BRIDGE_MIN_LENGTH = 3;
    private static final int BRIDGE_MAX_LENGTH = 20;

    @DisplayName("Bridge는 size가")
    @ParameterizedTest(name = "2이하 21이상이면 예외가 발생한다.")
    @MethodSource
    void bridgeSizeTest(List<String> direction) {
        assertThatThrownBy(() -> new Bridge(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> bridgeSizeTest() {
        List<String> underMinLength = IntStream.range(0, BRIDGE_MIN_LENGTH - 1)
                .mapToObj(i -> "U")
                .collect(Collectors.toList());
        List<String> overMaxLength = IntStream.range(0, BRIDGE_MAX_LENGTH + 1)
                .mapToObj(i -> "U")
                .collect(Collectors.toList());
        return Stream.of(
                Arguments.of(underMinLength),
                Arguments.of(overMaxLength)
        );
    }

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