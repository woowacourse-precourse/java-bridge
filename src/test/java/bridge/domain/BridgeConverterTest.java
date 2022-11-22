package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BridgeConverterTest {

    @Test
    void generatePosition_success() {
        assertThat(BridgeConverter.generatePosition(1)).isEqualTo("U");
        assertThat(BridgeConverter.generatePosition(0)).isEqualTo("D");
    }

    @Test
    void generatePosition_fail(){
        int number = 100;
        assertThatThrownBy(()->BridgeConverter.generatePosition(number)).isInstanceOf(IllegalArgumentException.class);
    }
}