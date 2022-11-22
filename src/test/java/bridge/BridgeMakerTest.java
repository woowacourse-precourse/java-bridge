package bridge;

import static bridge.utils.Constant.POOR_CONSTRUCTION;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUP() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    @DisplayName("다리가 입력한 다리길이에 맞게 생성")
    void makeBridge(int input) {
        List<String> bridge = bridgeMaker.makeBridge(input);
        assertThat(bridge.size()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    @DisplayName("다리 생성시 U, D만으로 생성")
    void findPoorConstruction(int input) {
        List<String> bridge = bridgeMaker.makeBridge(input);
        assertThat(bridge).doesNotContain(POOR_CONSTRUCTION);
    }
}
