package bridge.exception;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameExceptionTest {
    private final BridgeGameException bridgeGameException = new BridgeGameException();

    @Test
    @DisplayName("다리의 길이가 숫자로만 이뤄졌는지 확인하는 예외 테스트")
    public void validateBridgeSizeOnlyContainsNumberTest() {
        // given
        String input = "aa";

        // when, then
        assertThatThrownBy(() -> bridgeGameException.validateBridgeSizeOnlyContainsNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이가 허용된 범위 내에 수인지 확인하는 예외 테스트")
    public void validateBridgeSizePermittedLengthTest() {
        // given
        String input = "100";

        // when, then
        assertThatThrownBy(() -> bridgeGameException.validateBridgeSizePermittedLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
