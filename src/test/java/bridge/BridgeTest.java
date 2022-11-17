package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @MethodSource("createTestBridgeStatus")
    @ParameterizedTest
    void create(int index, BridgeMark answer) {
        List<BridgeMark> bridgeMarks = BridgeMark.of(List.of("U", "D", "U", "D"));
        assertThat(bridgeMarks.get(index)).isEqualTo(answer);
    }

    private static List<Arguments> createTestBridgeStatus() {
        return List.of(
                Arguments.of(0, BridgeMark.UP),
                Arguments.of(1, BridgeMark.DOWN),
                Arguments.of(2, BridgeMark.UP),
                Arguments.of(3, BridgeMark.DOWN)
        );
    }
}
