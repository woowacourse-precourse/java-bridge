package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OutputFormatTest {
    private OutputFormat outputFormat;

    @BeforeEach
    void setUp() {
        this.outputFormat = new OutputFormat();
    }

    @MethodSource
    private static Stream<Arguments> provideForPrintMapFormat() {
        return Stream.of(
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "U", "D")),
                        List.of(true, true, true),
                        List.of("[   | O |   ]\n[ O |   | O ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "U", "D")),
                        List.of(true, true, false),
                        List.of("[   | O | X ]\n[ O |   |   ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("U", "U", "U")),
                        List.of(true, true, true),
                        List.of("[ O | O | O ]\n[   |   |   ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("U", "U", "U")),
                        List.of(false, false, false),
                        List.of("[   |   |   ]\n[ X | X | X ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "D", "D")),
                        List.of(true, true, true),
                        List.of("[   |   |   ]\n[ O | O | O ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "D", "D")),
                        List.of(false, false, false),
                        List.of("[ X | X | X ]\n[   |   |   ]")
                )
        );
    }

    @ParameterizedTest(name = "다리 건너기 결과로 변환한다.")
    @MethodSource("provideForPrintMapFormat")
    void printMapFormat(Bridge bridge, List<Boolean> attempts, List<String> outputs) {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridge, attempts);

        assertThat(outputFormat.printMapFormat(bridgeGameResult)).containsSequence(outputs);
    }
}
