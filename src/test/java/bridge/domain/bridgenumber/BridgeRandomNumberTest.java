package bridge.domain.bridgenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeRandomNumberTest {

    @DisplayName("무작위 값이 0 또는 1이 아닌 경우 예외 발생")
    @Test
    void checkRandomNumberIsNotOneOrZero() {
        int bridgeRandomNumber = 3;
        assertThatThrownBy(() -> new BridgeRandomNumber(bridgeRandomNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
