package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    @Test
    @DisplayName("사용자 이동 테스트")
    void userMoveTest() {
        User user = new User(List.of("D","U","D","D"),4);
        user.userMove("D");
        assertThat(user.getUserSize()).isEqualTo(1);
    }
}