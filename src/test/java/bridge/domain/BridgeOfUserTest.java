package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeOfUserTest {
    private BridgeOfUser bridgeOfUser;

    @BeforeEach
    void beforeEach() {
        bridgeOfUser = new BridgeOfUser();
    }

    @DisplayName("윗 다리 테스트")
    @Test
    void 윗다리() {
        bridgeOfUser.restoreByRigth("U");
        bridgeOfUser.restoreByWrong("U");
        assertThat(bridgeOfUser.toString())
                .contains("[ O | X ]")
                .contains("[   |   ]");
    }

    @DisplayName("아랫 다리 테스트")
    @Test
    void 아랫다리() {
        bridgeOfUser.restoreByRigth("D");
        bridgeOfUser.restoreByWrong("D");
        assertThat(bridgeOfUser.toString())
                .contains("[   |   ]")
                .contains("[ O | X ]");
    }

    @DisplayName("잘못된 방향에 대해서는 예외를 발생시킨다.")
    @Test
    void 잘못된방향_예외처리() {
        assertThatThrownBy(() ->
                bridgeOfUser.restoreByRigth("a"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->
                bridgeOfUser.restoreByWrong("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}