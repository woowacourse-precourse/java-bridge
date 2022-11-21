package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    @Test
    @DisplayName("길이가 3인 bridge를 만든다. U와D만 존재하는지 확인한다.")
    public void createBridge_Size3_Success() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = maker.makeBridge(3);
        assertThat(bridge)
            .hasSize(3)
            .containsOnly("U", "D");
    }


    @Test
    @DisplayName("길이가 21인 bridge를 만들려고 시도하여 IllegalArgumentException이 발생한다.")
    public void createBridge_Size21_ThrowException() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> maker.makeBridge(21))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("길이가 2인 bridge를 만들려고 시도하여 IllegalArgumentException이 발생한다.")
    public void createBridge_Size2_ThrowException() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> maker.makeBridge(2))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("길이가 -1인 bridge를 만들려고 시도하여 IllegalArgumentException이 발생한다.")
    public void createBridge_SizeMinusOne_ThrowException() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> maker.makeBridge(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
    
}
