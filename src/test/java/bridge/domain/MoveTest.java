package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {

    @DisplayName("필요한 다리 위치, 사용자가 갈 방향, 이동할 수 있는 다리의 방향을 통해 올바른 상수를 얻는지 확인한다.")
    @MethodSource("generateMoveValue")
    @ParameterizedTest
    void checkFilterMove(String string, Direction bridgeDirection, Direction stepDirection, String expected) {
        // given
        String actual;

        // when
        actual = Move.getFilterBridgeMove(string, bridgeDirection, stepDirection);

        // then
        assertEquals(actual, expected, "[ERROR] 예상한 값과 다른 값이 나옵니다.");
    }

    static Stream<Arguments> generateMoveValue() {
        return Stream.of(
                Arguments.of("U", Direction.UP, Direction.UP, "O"),
                Arguments.of("U", Direction.UP, Direction.DOWN, " "),
                Arguments.of("D", Direction.UP, Direction.UP, "X"),
                Arguments.of("D", Direction.UP, Direction.DOWN, " "),
                Arguments.of("U", Direction.DOWN, Direction.UP, " "),
                Arguments.of("U", Direction.DOWN, Direction.DOWN, "X"),
                Arguments.of("D", Direction.DOWN, Direction.UP, " "),
                Arguments.of("D", Direction.DOWN, Direction.DOWN, "O")
        );
    }
}
