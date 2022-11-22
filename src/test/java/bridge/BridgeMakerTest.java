package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("입력받은 정수를 통해 다리를 정상적으로 생성하는지 여부를 테스트")
    @Test
    void BridgeMakingTest() {
        List<String> bridge = bridgeMaker.makeBridge(10);

        assertThat(bridge.size()).isEqualTo(10);
        assertThat(bridge).containsOnly("U", "D");
    }
    @DisplayName("생성하는 발판이 문자열이 맞는지 테스트")
    @Test
    void addTileTest(){
        assertThat(bridgeMaker.addTile()).isInstanceOf(String.class);
    }
}