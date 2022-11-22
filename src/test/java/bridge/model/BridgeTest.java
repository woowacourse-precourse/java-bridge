package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.model.Bridge;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void Bridge_테스트() {
        assertThat(new Bridge("O", " "));
    }

    @Test
    void Bridge_예외_테스트() {
        assertThatThrownBy(() -> new Bridge("d", "U")).isInstanceOf(IllegalArgumentException.class);
    }
}