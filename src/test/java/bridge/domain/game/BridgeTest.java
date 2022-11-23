package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("잘못된 구성 요소로 다리를 생성하면 예외가 발생한다.")
    @Test
    void createBridge_with_invalid_type() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "D", "e", "!", "D")))
                .isInstanceOf(IllegalStateException.class);
    }
}