package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {


    @DisplayName("다리 길이가 3 이상 20 이하의 숫자범위 초과시, 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1","2","21","22","100"})
    void isValidateSize(int size) {
        assertThatThrownBy(() -> new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

}