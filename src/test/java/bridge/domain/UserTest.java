package bridge.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("[User] 테스트")
class UserTest {

    @Test
    @DisplayName("User 생성자 테스트")
    void createUserTest() {
        User user = new User(Arrays.asList("D","D","D"));
        assertThat(user.getNumberOfAttempts())
                .isPositive()
                .isEqualTo(1);
    }

    @Test
    @DisplayName("게임 종료 여부 테스트")
    void onGameTest() {
        User user = new User(Arrays.asList("D","D","D"));
        assertThat(user.onGame())
                .isEqualTo(true);
    }
}