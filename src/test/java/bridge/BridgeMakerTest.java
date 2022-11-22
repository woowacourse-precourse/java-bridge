package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @ParameterizedTest(name = "{0}를 입력시 해당 사이즈에 맞는 다리가 생성된다.")
    @ValueSource(ints = {3, 10, 20})
    void makeBridgeTest(int size) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> makedBridge = maker.makeBridge(size);

        assertThat(makedBridge.size()).isEqualTo(size);
    }

    @ParameterizedTest(name = "사이즈가 3인 다리 생성시 랜덤으로 생성된 수가 {0}이면 {1}를 3개 가지는 다리가 생성된다.")
    @CsvSource({"0,D", "1,U"})
    void makeBridgeBlockTest(int randomNumber, String block) {
        BridgeMaker maker = new BridgeMaker(() -> randomNumber);
        List<String> makedBridge = maker.makeBridge(3);

        assertThat(makedBridge).containsExactly(block, block, block);
    }
}