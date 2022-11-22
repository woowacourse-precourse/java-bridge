package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    public void initialize() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("플레이어가 입력한 다리 길이와 생성된 다리의 길이가 동일한지 테스트")
    @Test
    public void makeBridgeTest() {
        int size = 4;
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(size);
    }
}
