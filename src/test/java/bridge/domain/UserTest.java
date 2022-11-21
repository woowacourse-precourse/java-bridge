package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserTest {

    @DisplayName("유저 이동 테스트")
    @Test
    void 유저는_Direction_입력받아_다리를_건넌다() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        User user = new User(bridge);

        user.move(Direction.U);
        user.move(Direction.D);
        user.move(Direction.U);

        assertThat(user).extracting("userPosition").isEqualTo(3);
    }


    @DisplayName("유저 사망 테스트")
    @Test
    void 유저가_다리의_잘못된_방향으로_움직이면_죽는다() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        User user = new User(bridge);

        user.move(Direction.U);
        user.move(Direction.D);
        user.move(Direction.D);

        assertThat(user.isAlive()).isFalse();
    }

    @DisplayName("유저가 다리 끝에서 움직이면 예외가 발생한다")
    @Test
    void 유저는_다리의_끝에_도달했을_때_이동하면_예외가_발생한다() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        User user = new User(bridge);

        user.move(Direction.U);
        user.move(Direction.D);
        user.move(Direction.U);

        assertThatThrownBy(() -> user.move(Direction.D))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저가 죽엇을 때 움직이면 예외가 발생한다")
    @Test
    void 유저는_다리의_끝에_죽었을_때_이동하면_예외가_발생한다() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        User user = new User(bridge);

        user.move(Direction.U);
        user.move(Direction.U);

        assertAll(() -> {
            assertThat(user.isAlive()).isFalse();
            assertThatThrownBy(() -> user.move(Direction.D))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

}