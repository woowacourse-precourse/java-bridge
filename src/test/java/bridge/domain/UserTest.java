package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
    }

    @DisplayName("isGameClear와 isRestartGame의 상태를 변경하고 true가 반환되어야 한다.")
    @Test
    void 플레이어_상태_변경_테스트() {
        boolean result = user.changeStatusIsFailed(false);
        assertEquals(result, true);
    }
}