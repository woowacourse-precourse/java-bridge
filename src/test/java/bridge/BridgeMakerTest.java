package bridge;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("다리 생성이 제대로 되는지 확인하는 테스트")
    @Test
    void makeBridgeTest() {
        assertThat(bridgeMaker.makeBridge(6).size())
                .isEqualTo(6);

        List<String> bridge = bridgeMaker.makeBridge(100);

        boolean result = bridge.stream()
                .allMatch(stairs -> stairs.equals("U") || stairs.equals("D"));
        assertThat(result).isTrue();
    }
}
