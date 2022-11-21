package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;
import bridge.domain.BridgeShape;
import bridge.domain.TryCount;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        this.outputView = new OutputView();
    }

    @ParameterizedTest(name = "총 시도한 횟수를 출력한다.")
    @ValueSource(ints = {1, 2, 3, 123, 435, 999})
    void printTryCountFormat(int count) {
        assertThat(outputView.printTryCountFormat(new TryCount(count))).isEqualTo("총 시도한 횟수: " + count);
    }

    public static Stream<Arguments> provideForPrintGameSuccessFormat() {
        return Stream.of(
                Arguments.of(
                        new BridgeGameResult(new Bridge(List.of(BridgeShape.UP)), List.of(true)),
                        "게임 성공 여부: 성공"
                ),
                Arguments.of(
                        new BridgeGameResult(new Bridge(List.of(BridgeShape.UP)), List.of(false)),
                        "게임 성공 여부: 실패"
                )
        );
    }

    @ParameterizedTest(name = "게임 결과가 성공인지 출력한다.")
    @MethodSource("provideForPrintGameSuccessFormat")
    void printGameSuccessFormat(BridgeGameResult bridgeGameResult, String expected) {
        assertThat(outputView.printGameSuccessFormat(bridgeGameResult)).isEqualTo(expected);
    }

    @MethodSource
    private static Stream<Arguments> provideForPrintMapFormat() {
        return Stream.of(
                Arguments.of(Bridge.createByBridgeShapeValue(List.of("D", "U", "D")), List.of(true, true, true),
                        List.of("[   | O |   ]\n[ O |   | O ]")),
                Arguments.of(Bridge.createByBridgeShapeValue(List.of("D", "U", "D")), List.of(true, true, false),
                        List.of("[   | O | X ]\n[ O |   |   ]")),
                Arguments.of(Bridge.createByBridgeShapeValue(List.of("U", "U", "U")), List.of(false, false, false),
                        List.of("[   |   |   ]\n[ X | X | X ]"))
        );
    }

    @ParameterizedTest(name = "다리 건너기 결과로 변환한다.")
    @MethodSource("provideForPrintMapFormat")
    void printMapFormat(Bridge bridge, List<Boolean> attempts, List<String> outputs) {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridge, attempts);

        assertThat(outputView.printMapFormat(bridgeGameResult)).containsSequence(outputs);
    }
}
