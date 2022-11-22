package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @Test
    void 다리_생성_크기_테스트() {
        // given
        int size = 10;

        // when
        List<String> bridge = new BridgeMaker(
                new BridgeRandomNumberGenerator()).makeBridge(size);

        // then
        assertThat(bridge.size()).isEqualTo(size);
    }
}
