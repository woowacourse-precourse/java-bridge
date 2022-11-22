package bridge;

import bridge.domain.Bridge;
import bridge.utils.constants.ErrorMessages;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void 다리_생성_통과() {
        Assertions.assertThatCode(() -> new Bridge(List.of("U", "D", "U")))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_다리_생성_U와D이외의_수() {
        Assertions.assertThatThrownBy(() -> new Bridge(List.of("A", "B", "C")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_BRIDGE.getMessage());
    }

    @Test
    void 예외_다리_생성_3미만의_크기() {
        Assertions.assertThatThrownBy(() -> new Bridge(List.of("U", "D")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_BRIDGE_SIZE.getMessage());
    }

    @Test
    void 예외_다리_생성_20초과의_크기() {
        Assertions.assertThatThrownBy(() -> new Bridge(
                        List.of("U", "U", "U", "U", "U", "U", "U", "U", "U",
                                "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_BRIDGE_SIZE.getMessage());
    }

}