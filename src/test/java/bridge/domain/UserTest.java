package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    Bridge bridge = new Bridge(
            List.of("U", "U", "U", "U", "U", "U", "U")
    );

    @Test
    @DisplayName("사용자의 초기값은 step = 0, live = true 이다")
    void initValue() {
        User user = new User();
        Assertions.assertThat(user.getStep()).isEqualTo(0);
        Assertions.assertThat(user.isLive()).isTrue();

        user.move(bridge, "U");
        user.init();
        Assertions.assertThat(user.getStep()).isEqualTo(0);
        Assertions.assertThat(user.isLive()).isTrue();
    }

    @DisplayName("사용자의 걸음수가 ")
    @ParameterizedTest(name = "{0}번 움직이면 step은 {0}")
    @CsvSource({"1", "3", "5"})
    void moveAndCheckStep(int step) {
        User user = new User();
        for (int i = 0; i < step; i++) {
            user.move(bridge, "U");
        }
        Assertions.assertThat(user.getStep()).isEqualTo(step);
    }

    @Nested
    @DisplayName("사용자가 다리에서 ")
    class checkInBridge {
        User user = new User();

        @Test
        @DisplayName("떨어지지 않았다.")
        void moveAndCheckLive() {
            user.move(bridge, "U");
            Assertions.assertThat(user.isLive()).isTrue();
        }

        @Test
        @DisplayName("떨어졌다.")
        void moveAndCheckDead() {
            user.move(bridge, "D");
            Assertions.assertThat(user.isLive()).isFalse();
        }
    }

    @DisplayName("사용자의 move에 잘못된값 입력시 예외")
    @ParameterizedTest(name = "입력값: {0}")
    @CsvSource({"a", "2", "hello world"})
    void moveWithWrongInput(String input) {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> {
            user.move(bridge, input);
        });
    }
}