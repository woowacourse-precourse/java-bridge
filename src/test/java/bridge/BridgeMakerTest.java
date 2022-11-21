package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {
    @DisplayName("입력 받은 길이에 따라 다리를 생성하는지를 테스트")
    @ValueSource(ints = {3, 5, 10, 20})
    @ParameterizedTest
    public void makeBridgeTest(int size) {
        assertThat(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(size))
                .containsAnyOf("U", "D")
                .hasSize(size);
    }
}
