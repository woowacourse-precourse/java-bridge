package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    @DisplayName("주어진 사이즈만큼 Bridge 생성 성공")
    void makeBridge_Success() {
        // Given
        int size = 3;

        // When
        List<String> bridge = bridgeMaker.makeBridge(size);

        // Then
        assertThat(bridge.size()).isEqualTo(3);
    }
}