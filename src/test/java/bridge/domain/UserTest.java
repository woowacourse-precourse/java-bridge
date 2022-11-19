package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("유저 테스트")
class UserTest {

    Bridge bridge = new Bridge(
            List.of(
                    new Floor("U"),
                    new Floor("U"),
                    new Floor("U"),
                    new Floor("U"),
                    new Floor("U"),
                    new Floor("U")
            ));

    @Test
    @DisplayName("사용자의 초기값: step = 0, live = true")
    void initValue() {
        User user = new User();
        Assertions.assertThat(user.getStep()).isEqualTo(0);
        Assertions.assertThat(user.isLive()).isTrue();

        user.move(bridge, "U");
        user.init();
        Assertions.assertThat(user.getStep()).isEqualTo(0);
        Assertions.assertThat(user.isLive()).isTrue();
    }

    @DisplayName("걸음수 테스트")
    @ParameterizedTest(name = "사용자가 {0}번 움직이면 step은 {0}")
    @CsvSource({"1", "3", "5"})
    void moveAndCheckStep(int step) {
        User user = new User();
        for (int i = 0; i < step; i++) {
            user.move(bridge, "U");
        }
        Assertions.assertThat(user.getStep()).isEqualTo(step);
    }

    @Nested
    @DisplayName("U U U... Bridge에서 생존여부")
    class checkInBridge {
        User user = new User();

        @Test
        @DisplayName("사용자가 U로 가면 생존")
        void moveAndCheckLive() {
            user.move(bridge, "U");
            Assertions.assertThat(user.isLive()).isTrue();
        }

        @Test
        @DisplayName("사용자가 D로 가면 사망")
        void moveAndCheckDead() {
            user.move(bridge, "D");
            Assertions.assertThat(user.isLive()).isFalse();
        }
    }

    @Nested
    @DisplayName("예외 테스트")
    class badInput {
        User user = new User();

        @DisplayName("move에 잘못된 입력시 예외")
        @ParameterizedTest(name = "{0} 입력시 예외")
        @CsvSource({"a", "2", "hello world"})
        void moveWithWrongInput(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                user.move(bridge, input);
            });
        }
    }
}