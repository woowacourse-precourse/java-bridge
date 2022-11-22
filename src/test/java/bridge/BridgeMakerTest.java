package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @ParameterizedTest(name = "{0}을 입력받으면 길이가 {0}인 List<String>을 반환한다.")
    @ValueSource(ints = {3, 9, 20})
    void createBridgeSuccess(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> stringList = bridgeMaker.makeBridge(size);

        assertThat(stringList).hasSize(size);
    }
}