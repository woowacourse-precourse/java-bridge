package bridge.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    List<String> list = Arrays.asList("U", "D", "U", "U", "D");
    Bridge bridge = new Bridge(list);

    @Test
    @DisplayName("bridge 반환하는 기능 테스트")
    void test_getBridge() {
        assertThat(bridge.getBridge()).isEqualTo(Arrays.asList("U", "D", "U", "U", "D"));
    }

    @Test
    @DisplayName("bridge size 반환하는 기능 테스트")
    void test_getSize() {
        assertThat(bridge.getSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("유효한 칸인지 확인하는 기능 테스트")
    void test_isValid() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            bridge.isValid(7, "U");
            bridge.isValid(5, "U");
        });
        assertThat(bridge.isValid(0, "U")).isTrue();
        assertThat(bridge.isValid(0, "D")).isFalse();
    }

}
