package bridge.util;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BridgeComparatorTest {
    @DisplayName("입력된 다리 값까지 정답이면 정답 결과 반환")
    @ParameterizedTest
    @MethodSource("generateSuccessData")
    void 두_개의_브릿지_비교_테스트_성공(Bridges bridges) {
        Bridge realBridges = bridges.realBridges;
        Bridge selectedBridges = bridges.selectedBridges;
        GameResult gameResult = BridgeComparator.compareBridges(realBridges, selectedBridges);

        Assertions.assertThat(gameResult)
                .usingRecursiveComparison()
                .isEqualTo(GameResult.success(selectedBridges));
    }

    @DisplayName("입력된 다리 값이 다르면 실패 결과 반환")
    @ParameterizedTest
    @MethodSource("generateFailData")
    void 두_개의_브릿지_비교_테스트_실패(Bridges bridges) {
        Bridge realBridges = bridges.realBridges;
        Bridge selectedBridges = bridges.selectedBridges;
        GameResult gameResult = BridgeComparator.compareBridges(realBridges, selectedBridges);

        Assertions.assertThat(gameResult)
                .usingRecursiveComparison()
                .isEqualTo(GameResult.fail(selectedBridges));
    }

    static Stream<Bridges> generateSuccessData() {
        return Stream.of(
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "D"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "D", "U"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "D", "U", "D"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "D", "U", "D", "U")))
        );
    }

    static Stream<Bridges> generateFailData() {
        return Stream.of(
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("D"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "U"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "D", "D"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "D", "U", "U"))),
                new Bridges(new Bridge(List.of("U", "D", "U", "D", "U")), new Bridge(List.of("U", "D", "U", "D", "D")))
        );
    }

    static class Bridges {
        Bridge realBridges;
        Bridge selectedBridges;

        Bridges(Bridge realBridges, Bridge selectedBridges) {
            this.realBridges = realBridges;
            this.selectedBridges = selectedBridges;
        }
    }
}