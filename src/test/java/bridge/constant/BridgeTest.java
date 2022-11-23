package bridge.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void toSign() {
        String lowerBridgeSign = Bridge.toSign(0);
        String upperBridgeSign = Bridge.toSign(1);

        Assertions.assertThat(lowerBridgeSign)
                .isEqualTo("D");
        Assertions.assertThat(upperBridgeSign)
                .isEqualTo("U");
    }

    @Test
    void contains() {
        boolean lowerBridge = Bridge.contains("D");
        boolean upperBridge = Bridge.contains("U");
        boolean nothing = Bridge.contains("UU");

        Assertions.assertThat(lowerBridge)
                .isTrue();
        Assertions.assertThat(upperBridge)
                .isTrue();
        Assertions.assertThat(nothing)
                .isFalse();
    }
}