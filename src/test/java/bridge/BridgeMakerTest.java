package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {

    @DisplayName("다리 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateData")
    void makeBridgeTest(List<Integer> numbers, int size, List<String> expected) {
        // given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(numbers);
        BridgeMaker maker = new BridgeMaker(numberGenerator);
        // when
        List<String> bridge = maker.makeBridge(size);
        // then
        assertThat(bridge).containsAll(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new ArrayList<>(List.of(0, 1, 1)), 3, List.of("D", "U", "U")),
                Arguments.of(new ArrayList<>(List.of(1, 0, 0, 1)), 4, List.of("U", "D", "D", "U")),
                Arguments.of(new ArrayList<>(List.of(1, 0, 1, 1, 0)), 5, List.of("U", "D", "U", "U", "D"))
        );
    }
}