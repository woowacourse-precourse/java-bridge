package bridge;

import bridge.enums.Direction;
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
    void 다리_생성_테스트(List<Integer> mockedBridge) {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(mockedBridge));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(mockedBridge.size());
        List<String> bridgeCompare = mockedBridge.stream()
                .map(Direction::getDirectionInitialOfNumber)
                .collect(Collectors.toList());

        assertThat(bridge).isEqualTo(bridgeCompare);
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