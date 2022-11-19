package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private static BridgeMaker maker;

    @BeforeAll
    static void init() {
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest
    @DisplayName("입력 받은 다리 길이에 대해 다리 생성")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void makeBridge(int inputSize) {
        assertThat(maker.makeBridge(inputSize)).hasSize(inputSize);
    }

    @ParameterizedTest
    @DisplayName("입력 받은 다리 길이가 1미만 일 때")
    @ValueSource(ints = {0, -1, -2, -3, -4})
    void makeBridgeUnderOne(int inputSize) {
        assertThat(maker.makeBridge(inputSize)).isEmpty();
    }

    @ParameterizedTest
    @DisplayName("생성된 다리 U 또는 D 포함 확인")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkUpDown(int inputSize) {
        assertThat(maker.makeBridge(inputSize))
                .filteredOn(upDown -> upDown.equals("U") || upDown.equals("D"))
                .hasSize(inputSize);
    }
}
