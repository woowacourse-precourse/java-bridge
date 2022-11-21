package bridge.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeBlockTest {

    @Test
    void of() {
        assertThat(BridgeBlock.of(1)).isEqualTo(BridgeBlock.U);
        assertThat(BridgeBlock.of(0)).isEqualTo(BridgeBlock.D);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void getBlockName(String name) {
        assertThat(BridgeBlock.getBlockName(name)).isEqualTo(name);
    }

    @Test
    void getBlockNameException() {
        assertThatThrownBy(() -> BridgeBlock.getBlockName("123"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}