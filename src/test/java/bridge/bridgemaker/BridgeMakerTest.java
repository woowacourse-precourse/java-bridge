package bridge.bridgemaker;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    @DisplayName("길이를 입력받으면 U, D만 구성된 문자열을 받는다.")
    @ValueSource(ints = {5, 10, 22, 32})
    @ParameterizedTest
    void isBridgeSquaresUOrD(int size){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge).containsOnly("U", "D");
    }

    @DisplayName("입력된 길이만큼 브릿지가 형성된다.")
    @ValueSource(ints = {5, 10, 22, 32})
    @ParameterizedTest
    void bridgeSizeTest(int size){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }
}
