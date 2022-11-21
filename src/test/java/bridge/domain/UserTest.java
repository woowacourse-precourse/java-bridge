package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void 사용자_지도그리기(){
        User user = new User();

        user.updateMapUserBridge("U",1);
        user.updateMapUserBridge("D",0);

        assertThat(" | O |  ").isEqualTo(user.getMapUpperUserBridge());
        assertThat(" |   | X").isEqualTo(user.getMapLowerUserBridge());
    }

    @Test
    void 재시작횟수_업데이트(){
        User user = new User();

        user.updateTryCount();

        assertThat(2).isEqualTo(user.getTryCount());
    }
}