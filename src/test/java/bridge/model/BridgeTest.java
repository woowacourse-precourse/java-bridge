package bridge.model;

import bridge.model.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    @DisplayName("Bridge 객체 생성 테스트")
    @Test
    void newBridgeTest() {
        assertThat(new Bridge(3))
                .isInstanceOf(Bridge.class);
        assertThat(new Bridge(10))
                .isInstanceOf(Bridge.class);
        assertThat(new Bridge(20))
                .isInstanceOf(Bridge.class);
    }

    @DisplayName("Bridge 객체 생성 예외 테스트")
    @Test
    void newBridgeExceptionTest() {
        assertThatThrownBy(() -> new Bridge(1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Bridge(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Bridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
