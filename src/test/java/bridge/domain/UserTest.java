package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User user;

    @BeforeEach
    void init() {
        user = new User();
    }

    @DisplayName("한 칸 이동한 후 position은 1이다.")
    @Test
    void move() {
        user.move();
        assertThat(user.getPosition()).isEqualTo(1);
    }

    @DisplayName("처음으로 돌아가면 position은 0이다.")
    @Test
    void returnStart() {
        user.move();
        user.move();
        assertThat(user.getPosition()).isEqualTo(2);
        user.returnStart();
        assertThat(user.getPosition()).isEqualTo(0);
    }
}