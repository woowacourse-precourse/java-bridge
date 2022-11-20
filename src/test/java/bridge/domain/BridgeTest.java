package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.Move.*;
import static bridge.domain.MoveResult.*;
import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @DisplayName("다리를 끝까지 건너면 true가 반환된다.")
    @MethodSource("bridgeFinishTestData")
    @ParameterizedTest(name = "다리:{0}, 길이:{1}, 결과:{2}")
    public void bridgeFinishTest(Bridge bridge, int distance, boolean result) {
        assertThat(bridge.isFinish(distance)).isEqualTo(result);
    }

    @DisplayName("다리 건너기 입력에 따라 MoveResult 결과(SUCCESS, FAIL)가 반환된다.")
    @MethodSource("crossBridgeTestData")
    @ParameterizedTest(name = "다리:{0}, 입력: {1}, 결과: {2}")
    public void crossBridgeTest(Bridge bridge, List<Move> input, List<MoveResult> expectResults) {
        List<MoveResult> realResults = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            realResults.add(bridge.crossBridge(i, input.get(i)));
        }

        assertThat(realResults).isEqualTo(expectResults);
    }

    static Stream<Arguments> crossBridgeTestData() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        return Stream.of(
                Arguments.of(bridge,
                        List.of(UP, DOWN, UP, DOWN), List.of(SUCCESS, SUCCESS, SUCCESS, SUCCESS)),
                Arguments.of(bridge,
                        List.of(DOWN, UP, DOWN, UP), List.of(FAIL, FAIL, FAIL, FAIL)),
                Arguments.of(bridge,
                        List.of(UP, DOWN, DOWN, UP), List.of(SUCCESS, SUCCESS, FAIL, FAIL))
        );
    }

    static Stream<Arguments> bridgeFinishTestData() {
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        return Stream.of(
                Arguments.of(bridge, 0, false),
                Arguments.of(bridge, 1, false),
                Arguments.of(bridge, 2, false),
                Arguments.of(bridge, 3, true),
                Arguments.of(bridge, 4, false)
        );
    }
}