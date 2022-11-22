package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @DisplayName("다리 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints={4,5})
    public void makeAnswerBridge(int num){
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(num).size()).isEqualTo(num);
    }
}
