package bridge.domain;

import bridge.domain.type.MoveResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeWalkerTest {
    List<String> bridge;
    private BridgeWalker bridgeWalker;

    static Stream<Arguments> getResourceForNotCrossAllStep() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of("U", "D")),
                Arguments.of(List.of("U", "D", "D"))
        );
    }

    static Stream<Arguments> getResourceForMove() {
        return Stream.of(
                Arguments.of("U", MoveResultType.SUCCESS),
                Arguments.of("D", MoveResultType.FAIL)
        );
    }

    @BeforeEach
    void setUp() {
        bridge = List.of("U", "D", "U");
        bridgeWalker = new BridgeWalker(new MoveRecord(), Bridge.from(bridge));
    }

    void crossStep(String moveCommand) {
        bridgeWalker.move(moveCommand);
    }

    void crossAllStep() {
        bridge.forEach(moveCommand -> {
            bridgeWalker.move(moveCommand);
        });
    }

    @Test
    @DisplayName("BridgeWalker가 다리를 전부 건넜음을 올바르게 반환하는지 검사")
    void TestIsCrossAllStep() {
        crossAllStep();
        assertThat(bridgeWalker.isCrossAllStep()).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("getResourceForNotCrossAllStep")
    @DisplayName("BridgeWalker가 다리를 전부 건너지않았음을 올바르게 반환하는지 검사")
    void TestIsNotCrossAllStep(List<String> moveCommands) {
        moveCommands.forEach(moveCommand -> {
            crossStep(moveCommand);
        });
        assertThat(bridgeWalker.isCrossAllStep()).isEqualTo(false);
    }

    @ParameterizedTest
    @MethodSource("getResourceForMove")
    @DisplayName("")
    void TestMove(String moveCommand, MoveResultType moveResultType) {
        assertThat(bridgeWalker.move(moveCommand)).isEqualTo(moveResultType);
    }
}
