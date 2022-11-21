package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BridgeMakerTest {
    @DisplayName("다리의 길이가 맞지 않는 범위 라면 예외 처리.")
    @ParameterizedTest
    @CsvSource({"-1", "2", "21", "20000"})
    void validateBridgeLengthByOverSize(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> bridgeMaker.validateSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("무작위로 생성된 값이 0이나 1이 아닌 경우 예외 처리")
    @ParameterizedTest
    @CsvSource({"-1", "2", "1.5"})
    void validateBridgeRandomNumberGenerator() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> bridgeMaker.validateRandomNumber(bridgeMaker.generateNumber()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}