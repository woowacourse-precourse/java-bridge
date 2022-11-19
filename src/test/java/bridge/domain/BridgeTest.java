package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.MoveResult.*;
import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @DisplayName("입력에 따라 다리 건너기 테스트")
    @MethodSource("crossBridgeData")
    @ParameterizedTest(name = "bridge= {0}, input= {1}, results= {2}")
    public void crossBridgeTest(Bridge bridge, List<String> input, List<MoveResult> expectResults) {
        List<MoveResult> realResults = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            realResults.add(bridge.crossBridge(i, input.get(i)));
        }

        assertThat(realResults).isEqualTo(expectResults);
    }

    static Stream<Arguments> crossBridgeData() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        return Stream.of(
                Arguments.of(bridge,
                        List.of("U", "D", "U", "D"), List.of(SUCCESS, SUCCESS, SUCCESS, SUCCESS)),
                Arguments.of(bridge,
                        List.of("D", "U", "D", "U"), List.of(FAIL, FAIL, FAIL, FAIL)),
                Arguments.of(bridge,
                        List.of("U", "D", "D", "U"), List.of(SUCCESS, SUCCESS, FAIL, FAIL))
        );
    }
}