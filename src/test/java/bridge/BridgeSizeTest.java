package bridge;

import bridge.Model.VO.BridgeSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BridgeSizeTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 9, 10, 11, 17, 19, 20})
    @DisplayName("유효")
    void valid(int size) {
        BridgeSize actual = new BridgeSize(size);
        assertThat(actual).isInstanceOf(BridgeSize.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, -1, -20, 32, 21})
    @DisplayName("예외")
    void notValid(int size) {
        assertThatThrownBy(() -> {
            new BridgeSize(size);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}
