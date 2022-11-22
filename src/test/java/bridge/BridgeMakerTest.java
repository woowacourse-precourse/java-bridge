package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("다리 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeBridgeParam")
    void makeBridge(List<Integer> numbers, List<String> expectedBridge) {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(numbers);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(numbers.size());
        assertThat(bridge).isEqualTo(expectedBridge);
    }

    static Stream<Arguments> makeBridgeParam() {
        return Stream.of(
                Arguments.of(newArrayList(0,1,0), newArrayList("D", "U", "D")),
                Arguments.of(newArrayList(1,1,1,1,1), newArrayList("U", "U", "U", "U", "U")),
                Arguments.of(newArrayList(0,0,0,0,0,0,1), newArrayList("D", "D", "D", "D", "D", "D", "U"))
        );
    }
}