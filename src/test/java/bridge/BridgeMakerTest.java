package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리의 길이만큼의 리스트를 생성한다.")
    @Test
    void createBridgeBySize() {
        int size = 3;
        Assertions.assertThat(bridgeMaker.makeBridge(size)).size().isEqualTo(size);
    }

    @DisplayName("U, D로만 이뤄진 다리를 생성한다.")
    @Test
    void createBridgeByUOrD() {
        int size = 3;
        List<String> bridge = bridgeMaker.makeBridge(size);

        Assertions.assertThat(bridge.stream()
                .filter(character -> character.equals("U") || character.equals("D"))
                .count()).isEqualTo(size);
    }
}
