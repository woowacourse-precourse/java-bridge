package bridge.domain;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.enums.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Bridge 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeTest {

    private Bridge bridge;

    private static Stream<Arguments> generateArgumentForCanCross() {
        return Stream.of(
                Arguments.of(0, Direction.UP, true),
                Arguments.of(0, Direction.DOWN, false),
                Arguments.of(1, Direction.UP, false),
                Arguments.of(1, Direction.DOWN, true),
                Arguments.of(2, Direction.UP, true),
                Arguments.of(2, Direction.DOWN, false)
        );
    }

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
        assertThat(bridge).isNotNull();
    }

    @Test
    void 생성된_다리_크기_검사() {
        assertThat(bridge.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "position : {0} direction : {1} : canCross : {2}")
    @MethodSource("generateArgumentForCanCross")
    void 다리를_건널수_있는지_검사(int position, Direction direction, boolean expected) {
        boolean actual = bridge.canCross(position, direction);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 불변_객체_검사() {
        List<String> bridge = new ArrayList<>();
        bridge.add("U");
        bridge.add("D");
        bridge.add("D");
        Bridge unmodifiableBridge = new Bridge(bridge);
        bridge.add("D");
        assertThat(unmodifiableBridge)
                .extracting("bridge", as(InstanceOfAssertFactories.LIST))
                .containsExactly("U", "D", "D");
    }
}
