package bridge.view.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BridgeLengthTest {

    @Test
    void 제한된_다리길이_출력성공() throws Exception {
        assertThat(BridgeLength.MAX_BRIDGE_LENGTH.getLength()).isEqualTo(20);
    }

}