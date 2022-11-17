package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void 입력받은_길이와_생성된_다리의_길이가_같은지_테스트(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge.size()).isEqualTo(5);
    }

    @Test
    void 칸의_정보가_U_D만_있는지_테스트(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(20);
        for (String code : bridge) {
            assertThat(code).isIn(List.of("U", "D"));
        }
    }
}