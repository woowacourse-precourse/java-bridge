package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void 객체_생성() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void 다리_생성_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size()).isEqualTo(3);
        assertThat(bridge.stream().filter(value -> (!(value.equals("U") || value.equals("D")))).collect(Collectors.toList())).isEmpty();
    }

}