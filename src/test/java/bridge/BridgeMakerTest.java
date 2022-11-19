package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

class BridgeMakerTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = Mockito.mock(BridgeRandomNumberGenerator.class);
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("3에서 20사이에 다리 길이 이외의 입력을 받은 경우 예외")
    @ParameterizedTest
    @CsvSource({
            "2", "1", "0", "21", "22", "100", "-1"
    })
    void throwExceptionWhenInputNotIncludeFromThreeToTwenty(int input) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 생성기가 1, 0 이외에 잘못된 값을 리턴한 경우")
    @Test
    void throwExceptionWhenRandomGeneratorCreateInvalidNumber() {
        // given
        when(bridgeNumberGenerator.generate()).thenReturn(3);
        final int VALID_NUMBER = 10;

        // expect
        assertThatThrownBy(() -> bridgeMaker.makeBridge(VALID_NUMBER)).isInstanceOf(IllegalArgumentException.class);
    }

}