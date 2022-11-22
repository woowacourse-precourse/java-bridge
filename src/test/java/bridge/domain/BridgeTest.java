package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @DisplayName("다리의 길이가 20보다 크면 예외가 발생한다.")
    @Test
    void createBridgeByOverRange() {
        assertThatThrownBy(() -> Bridge.of(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3보다 작으면 예외가 발생한다.")
    @Test
    void createBridgeByLowerRange() {
        assertThatThrownBy(() -> Bridge.of(2))
                .isInstanceOf(IllegalArgumentException.class);
    }


}