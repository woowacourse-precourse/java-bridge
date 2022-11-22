package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class BridgeFormatValidatorTest {

    @DisplayName("리스트에 U와 D 이외의 문자가 있으면 예외가 발생한다.")
    @Test
    void validateInvalidBridgeFormat() {
        assertThatThrownBy(() -> BridgeFormatValidator.validate(List.of("U", "A", "D")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}