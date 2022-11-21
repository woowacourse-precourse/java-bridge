package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력된 크기만큼 다리가 생성되는지 확인")
    @ValueSource(strings = {"10", "3", "100", "123", "999", "1000", "10000"})
    @ParameterizedTest
    void makeBridge_입력된_크기만큼_다리가_생성되는지_확인(Integer size) {
        assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(size);
    }

    @DisplayName("생성된 다리가 U, D만 포함하는지 확인")
    @ValueSource(strings = {"10", "3", "100", "123", "999", "1000", "10000"})
    @ParameterizedTest
    void makeBridge_U_D_만_포함하는지_확인(Integer size) {
        assertThat(bridgeMaker.makeBridge(size)).contains("U", "D");
    }
}