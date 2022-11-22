package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @ParameterizedTest(name = "{0}을 입력시 길이가 {0}인 List 반환")
    @ValueSource(ints = {1, 5, 15})
    void createBridgeSuccess(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> stringList = bridgeMaker.makeBridge(size);

        assertThat(stringList).hasSize(size);
    }

}