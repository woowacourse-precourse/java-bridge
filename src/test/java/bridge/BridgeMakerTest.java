package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class BridgeMakerTest {

    @DisplayName("입력 받은 다리 길이만큼 다리를 생성하는지 검증한다.")
    @Test
    void makeBridgeWithSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 10;

        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge).hasSize(size);
    }

    @DisplayName("다리가 위(U), 아래(D) 두 칸으로만 이루어져있는지 검증한다.")
    @Test
    void makeBridgeContainingOnlyUpOrDown() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(3);

        assertThat(bridge).containsAnyOf("U", "D");
    }

}