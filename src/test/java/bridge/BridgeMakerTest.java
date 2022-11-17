package bridge;

import bridge.Enum.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @DisplayName("다리 생성 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @MethodSource("generateData")
    void 다리_생성_테스트(List<Integer> mocked_bridge) {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(mocked_bridge));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(mocked_bridge.size());
        List<String> bridge_compare = mocked_bridge.stream()
                .map(num -> Direction.getDirectionOfNumber(num).getInitial())
                .collect(Collectors.toList());

        assertThat(bridge).isEqualTo(bridge_compare);
    }

    static Stream<List<Integer>> generateData() {
        return Stream.of(
                List.of(0,1,0,0,1,0,1,1,1,0),
                List.of(1,1,1,1,1,1,1,1,1,1),
                List.of(0,0,0,0,0,0,0,0,0,0),
                List.of(0,1,0,1,1,0,1,0,1,0,0,1,0,1,1,0,1,0,1,0)
                );
    }
}