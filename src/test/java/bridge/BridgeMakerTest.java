package bridge;

import static org.assertj.core.api.Assertions.assertThat;

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

}
