package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.TestNumberGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {

    @ParameterizedTest
    @MethodSource("generateMakingBridgeArguments")
    @DisplayName("[정상] 다리의 길이를 입력 받아 U,D 로 이루어진 List 생성")
    void makeBridge(int size, List<Integer> numbers, String[] strings) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(numbers);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        List<String> result = bridgeMaker.makeBridge(size);
        assertThat(result).containsExactly(strings);
    }


    static Stream<Arguments> generateMakingBridgeArguments() {
        return Stream.of(
                Arguments.of(3, newArrayList(1, 0, 0), new String[]{"U", "D", "D"}),
                Arguments.of(3, newArrayList(0, 0, 1), new String[]{"D", "D", "U"}),
                Arguments.of(4, newArrayList(1, 0, 0, 1), new String[]{"U", "D", "D", "U"}),
                Arguments.of(9,
                        newArrayList(1, 1, 1, 1, 1, 1, 1, 1, 0),
                        new String[]{"U", "U", "U", "U", "U", "U", "U", "U", "D"}
                )
        );
    }
}
