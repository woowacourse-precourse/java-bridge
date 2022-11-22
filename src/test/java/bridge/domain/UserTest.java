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
        User user = new User(Arrays.asList("D", "D", "D"));
        assertThat(user.getNumberOfAttempts())
                .isPositive()
                .isEqualTo(1);
    }

    @Test
    @DisplayName("게임 종료 여부 테스트")
    void onGameTest() {
        User user = new User(Arrays.asList("D", "D", "D"));
        assertThat(user.onGame())
                .isEqualTo(true);
    }

    @Test
    @DisplayName("사용자의 이동 저장 테스트")
    void addMoveTest() {
        User user = new User(Arrays.asList("D", "D", "D"));
        user.addMove("D");
        assertThat(user.getUserBridge().size())
                .isEqualTo(1);
        assertThat(user.getUserBridge())
                .contains("D");
    }

    @Test
    @DisplayName("사용자가 올바른 다리를 건넜을 때 테스트")
    void checkBridgeCorrectTest() {
        User user = new User(Arrays.asList("D", "D", "D"));
        user.addMove("D");
        user.addMove("D");
        assertThat(user.checkBridge())
                .isEqualTo(false);
    }

    @Test
    @DisplayName("사용자가 잘못된 다리를 건넜을 때 테스트")
    void checkBridgeWrongTest() {
        User user = new User(Arrays.asList("D", "D", "D"));
        user.addMove("D");
        user.addMove("U");
        assertThat(user.checkBridge())
                .isEqualTo(true);
    }

    @Test
    @DisplayName("게임 재시작 테스트")
    void restartGameTest() {
        User user = new User(Arrays.asList("D", "D", "D"));
        user.addMove("D");
        user.addMove("U");
        user.restartGame();
        assertThat(user.getNumberOfAttempts())
                .isEqualTo(2);
        assertThat(user.getUserBridge())
                .isEmpty();
    }
}