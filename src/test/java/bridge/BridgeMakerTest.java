package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리의 길이만큼의 리스트를 생성한다.")
    @Test
    void createBridgeBySize() {
        int size = 3;
        Assertions.assertThat(bridgeMaker.makeBridge(size)).size().isEqualTo(size);
    }
}
