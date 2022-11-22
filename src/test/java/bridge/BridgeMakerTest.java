package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    @DisplayName("입력된 크기만큼 다리가 만들어지는지 테스트")
    @ValueSource(ints = {3, 10, 20})
    @ParameterizedTest
    void makeBridge(int input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list = bridgeMaker.makeBridge(input);
        assertThat(list.size()).isEqualTo(input);
        assertThat(list).containsAnyOf("U", "D");
    }
}
