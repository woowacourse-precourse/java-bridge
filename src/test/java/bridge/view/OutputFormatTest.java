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
    private static Stream<Arguments> provideForBridgeGameResultFormat() {
        return Stream.of(
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "U", "D")),
                        List.of(true, true, true),
                        List.of("[   | O |   ]", "[ O |   | O ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "U", "D")),
                        List.of(true, true, false),
                        List.of("[   | O | X ]", "[ O |   |   ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("U", "U", "U")),
                        List.of(true, true, true),
                        List.of("[ O | O | O ]", "[   |   |   ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("U", "U", "U")),
                        List.of(false, false, false),
                        List.of("[   |   |   ]", "[ X | X | X ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "D", "D")),
                        List.of(true, true, true),
                        List.of("[   |   |   ]", "[ O | O | O ]")
                ),
                Arguments.of(
                        Bridge.createByBridgeShapeValue(List.of("D", "D", "D")),
                        List.of(false, false, false),
                        List.of("[ X | X | X ]", "[   |   |   ]")
                )
        );
    }

    @ParameterizedTest(name = "다리 건너기 결과를 출력한다")
    @MethodSource("provideForBridgeGameResultFormat")
    void bridgeGameResultFormat(Bridge bridge, List<Boolean> attempts, List<String> outputs) {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridge, attempts);

        assertThat(outputFormat.bridgeGameResultFormat(bridgeGameResult)).containsSequence(outputs);
    }
}
