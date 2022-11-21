package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("인자로 받는 이동 가능한 칸들에 U, D가 아닌 다른 게 있으면 예외처리한다")
    @Test
    void makeBridgeByInValidMovableSpaces() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "D", "X")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("인자로 받는 이동 가능한 칸들에 U, D만 있으면 괜찮다")
    @Test
    void makeBridgeByValidMovableSpaces() {
        assertThatCode(() -> new Bridge(List.of("U", "D", "D")))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동한 칸에 발판이 있으면 있다고 확인되는지 테스트")
    @Test
    void checkIsNotBroken() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.isBroken(1, "U")).isFalse();
    }

    @DisplayName("이동한 칸에 발판이 없으면 없다고 확인되는지 테스트")
    @Test
    void checkIsBroken() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.isBroken(1, "D")).isTrue();
    }
}
