package bridge.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BridgeDirectionTest {

    @Test
    void numberToCapital_1일때_U_반환() {
        assertThat(BridgeDirection.numberToCapital(1)).isEqualTo("U");
    }

    @Test
    void numberToCapital_0일때_D_반환() {
        assertThat(BridgeDirection.numberToCapital(0)).isEqualTo("D");
    }
}