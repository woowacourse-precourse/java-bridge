package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("User 객체를 테스트한다.")
class UserTest {

    Bridge bridge = new Bridge(
            List.of("U", "U", "U", "U", "U", "U", "U")
    );

    @Test
    @DisplayName("User 객체의 초기값은 step = 0, live = true 이다")
    void initValue() {
        User user = new User();
        Assertions.assertThat(user.getStep()).isEqualTo(0);
        Assertions.assertThat(user.isLive()).isTrue();

        user.move(bridge, "U");
        user.init();
        Assertions.assertThat(user.getStep()).isEqualTo(0);
        Assertions.assertThat(user.isLive()).isTrue();
    }

    @DisplayName("move 함수가 호출될때마다 User의 step이 1씩 증가한다.")
    @ParameterizedTest(name = "{0}번 호출")
    @CsvSource({"1", "3", "5", "10000000"})
    void moveAndCheckStep(int step) {
        User user = new User();
        for (int i = 0; i < step; i++) {
            user.move(bridge, "U");
        }
        Assertions.assertThat(user.getStep()).isEqualTo(step);
    }

    @Nested
    @DisplayName("move 함수는 bridge와 이동방향(U/D)을 입력받아 사용자의 상태를 갱신한다.")
    class checkInBridge {
        User user = new User();

        @Test
        @DisplayName("옳은 방향으로 이동한다.")
        void moveAndCheckLive() {
            user.move(bridge, "U");
            Assertions.assertThat(user.isLive()).isTrue();
        }

        @Test
        @DisplayName("잘못된 방향으로 이동한다.")
        void moveAndCheckNotLive() {
            user.move(bridge, "D");
            Assertions.assertThat(user.isLive()).isFalse();
        }

        @DisplayName("move에 잘못된 이동방향 입력시 예외")
        @ParameterizedTest(name = "입력값: {0}")
        @CsvSource({"a", "2", "hello world"})
        void moveWrongMovementInput(String input) {
            User user = new User();

            assertThrows(IllegalArgumentException.class, () -> {
                user.move(bridge, input);
            });
        }
    }
}