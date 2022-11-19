package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeMakerTest {

    @DisplayName("입력받은 만큼 다리 길이가 생성됐는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 19, 20})
    public void checkInValidateRange(int size){
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        // when
        List<String> bridge = bridgeMaker.makeBridge(size);
        // then
        Assertions.assertThat(bridge.size()).isEqualTo(size);
    }
}
