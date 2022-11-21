package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    void 사용자_지도그리기(){
        User user = new User();

        user.updateMapBridge("U",1);
        user.updateMapBridge("D",0);

        assertThat(" | O |  ").isEqualTo(user.getMapUpperBridge());
        assertThat(" |   | X").isEqualTo(user.getMapLowerBridge());
    }

    @Test
    void 재시작횟수_업데이트(){
        User user = new User();

        user.updateTryCount();

        assertThat(2).isEqualTo(user.getTryCount());
    }
}