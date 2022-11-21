package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {
    Bridge bridge = new Bridge(List.of(Direction.D, Direction.D, Direction.D));

    @ParameterizedTest(name = "index -> {0}")
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("다리를 건너갔는지 확인한다.")
    void isMoved_DirectionEqualsBridgeInSameIndex_True(int index) {
        assertThat(bridge.isMoved(Direction.D, index)).isTrue();
    }
}