package bridge.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMarkTest {

    @DisplayName("U가 주어질 때 BridgeMark 생성")
    @Test
    void createBridgeMark() {
        BridgeMark markUp = BridgeMark.of("U");
        BridgeMark markDown = BridgeMark.of("D");
        assertThat(markUp.isUp()).isTrue();
        assertThat(markDown.isDown()).isTrue();
    }
}
