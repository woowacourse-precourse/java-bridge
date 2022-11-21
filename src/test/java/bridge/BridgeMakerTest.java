package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("다리 길이를 통해 다리를 생성할 수 있습니다.")
    void testMakeBridge_success() throws Exception {
        //given
        int size = 5;

        //when
        List<String> bridge = bridgeMaker.makeBridge(5);

        //then
        assertThat(bridge.size()).isEqualTo(5);
        assertThat(bridge).containsOnly("U", "D");
    }
}