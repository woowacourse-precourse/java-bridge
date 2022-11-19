package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {
    @DisplayName("Size 값 만큼 다리가 생성 되는지 확인 테스트")
    @ParameterizedTest
    @CsvSource({"3", "5", "17", "20"})
    void succeedBridgeMaking(int size) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        assertThat(bridgeMaker.makeBridge(size)).hasSize(size);
    }
}