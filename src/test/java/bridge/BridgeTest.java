package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @MethodSource("createTestBridgeStatus")
    @ParameterizedTest
    void create(int index, BridgeStatus answer) {
        List<BridgeStatus> bridgeStatuses = BridgeStatus.of(List.of("U", "D", "U", "D"));
        assertThat(bridgeStatuses.get(index)).isEqualTo(answer);
    }

    private static List<Arguments> createTestBridgeStatus() {
        return List.of(
                Arguments.of(0, BridgeStatus.UP),
                Arguments.of(1, BridgeStatus.DOWN),
                Arguments.of(2, BridgeStatus.UP),
                Arguments.of(3, BridgeStatus.DOWN)
        );
    }
}
