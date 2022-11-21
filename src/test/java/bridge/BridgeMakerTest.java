package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.Domain.BridgeMaker;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    BridgeMaker bridgeMaker;

    @BeforeEach
    void before() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @DisplayName("입력받은 크기만큼의 다리를 만들어준다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 3, 5, 11})
    void makeBridgeTestBySize(int input) {
        List<String> bridge = bridgeMaker.makeBridge(input);

        assertThat(bridge.size()).isEqualTo(input);
    }

    @DisplayName("만들어진 다리가 U와 D로만 이루어져 있어야한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 3, 5, 11})
    void makeBridgeTestByContent(int input) {
        List<String> bridge = bridgeMaker.makeBridge(input);
        String regex = "^[UD]$";

        assertThat(bridge.stream().filter(s -> s.matches(regex)).count()).isEqualTo(input);
    }

}
