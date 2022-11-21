package bridge.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.constants.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @DisplayName("Normal BridgeSize")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(ints = {3, 5, 10, 15, 20})
    void Validate_BridgeSize_exception(int input) {
        assertThat(BridgeSize.from(input).getValue()).isEqualTo(input);
    }

    @DisplayName("Unvalidated BridgeSize Range")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(ints = {-1, 0, 2, 21, 30})
    void Unvalidated_BridgeSize_exception(int input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            BridgeSize.from(input);
        });
        assertEquals(ErrorCode.SIZE_NOT_IN_RANGE.getException().getMessage(),
                exception.getMessage());
    }
}