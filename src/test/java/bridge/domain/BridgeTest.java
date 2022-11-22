package bridge.domain;

import bridge.domain.type.MoveResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private Bridge bridge;

    static Stream<Arguments> getPositions() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(4, false),
                Arguments.of(5, true)
        );
    }

    static Stream<Arguments> getMoveCommandAndPosition() {
        return Stream.of(
                Arguments.of("D", 0, false),
                Arguments.of("U", 0, true),
                Arguments.of("U", 1, true),
                Arguments.of("U", 4, false)
        );
    }

    static Stream<Arguments> getSourceForMoveResult() {
        return Stream.of(
                Arguments.of("D", 0, MoveResultType.FAIL),
                Arguments.of("U", 0, MoveResultType.SUCCESS),
                Arguments.of("D", 1, MoveResultType.FAIL),
                Arguments.of("D", 2, MoveResultType.SUCCESS)
        );
    }

    @BeforeEach
    void setUp() {
        this.bridge = Bridge.from(List.of("U", "U", "D", "U", "D"));
    }

    @ParameterizedTest
    @MethodSource("getPositions")
    @DisplayName("position이 Bridge의 End인지 아닌지를 검사")
    void TestIsEndOfBridge(int postion, boolean result) {
        assertThat(bridge.isEndOfBridge(postion)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("getMoveCommandAndPosition")
    @DisplayName("position의 moveCommand가 movable한 블록인지 아닌지를 검사")
    void TestIsMovable(String moveCommand, int position, boolean result) {
        assertThat(bridge.isMovable(moveCommand, position)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("getSourceForMoveResult")
    @DisplayName("position의 moveCommand를 가지고 올바른 MoveResult를 반환하는지 검사")
    void TestGetMovaResult(String moveCommand, int position, MoveResultType moveResultType) {
        assertThat(bridge.getMoveResult(moveCommand, position)).isEqualTo(moveResultType);
    }
}
