package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CompareBridgeTest {
    private CompareBridge compareBridge;
    private Player player;
    private List<String> bridge;

    @BeforeEach
    void beforeEach() {
        player = new Player(new ArrayList<>());
        bridge = new ArrayList<>();
        compareBridge = new CompareBridge(bridge);
    }

    @DisplayName("입력값과 다리 패널의 값이 같은지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("sameTestData")
    void isSameTest(List<String> movingInputs, List<String> bridge) {
        // given
        player = new Player(movingInputs);
        compareBridge = new CompareBridge(bridge);
        String panel = bridge.get(0);

        // when, then
        assertThat(compareBridge.isSame(player.getMovingChoices().get(0), panel)).isTrue();
    }

    @DisplayName("한 칸 이동하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("steppingTestData")
    void steppingTest(List<String> movingInputs, List<String> bridge, List<Boolean> expected) {
        // given
        player = new Player(movingInputs);
        compareBridge = new CompareBridge(bridge);

        // when, then
        assertThat(compareBridge.canStepping(player)).isEqualTo(expected);
    }

    static Stream<Arguments> sameTestData() {
        return Stream.of(
                Arguments.of(List.of("D"), List.of("D", "U", "U")),
                Arguments.of(List.of("U"), List.of("U", "D", "D", "U")),
                Arguments.of(List.of("U"), List.of("U", "D", "U", "U", "D"))
        );
    }

    static Stream<Arguments> steppingTestData() {
        return Stream.of(
                Arguments.of(List.of("D"), List.of("D", "U", "U"), List.of(true)),
                Arguments.of(List.of("U"), List.of("D", "U", "U"), List.of(false))
        );
    }
}