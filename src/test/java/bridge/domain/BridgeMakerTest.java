package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private static BridgeMaker bridgeMaker;

    @BeforeAll
    static void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("만든 다리의 길이는 입력받은 사이즈와 같아야 한다.")
    @Test
    void bridgeSize() {
        int size = 5;
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(size);
    }


    @DisplayName("다리의 요소들은 U와 D 문자로만 이루어져있어야 한다.")
    @Test
    void bridgeElement() {
        int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge).contains("U", "D");
    }
}