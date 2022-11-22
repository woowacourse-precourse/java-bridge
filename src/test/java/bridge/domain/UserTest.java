package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    void 사용자_지도그리기(){
        User user = new User();

        user.updateMapBridge("U",true);
        user.updateMapBridge("D",false);

        System.out.println("user.getMapUpperBridge() = " + user.getMapUpperBridge());
        System.out.println("user.getMapLowerBridge() = " + user.getMapLowerBridge());
        assertThat(Arrays.asList("O"," ")).isEqualTo(user.getMapUpperBridge());
        assertThat(Arrays.asList(" ","X")).isEqualTo(user.getMapLowerBridge());
    }

    @Test
    void 재시작횟수_업데이트(){
        User user = new User();

        user.updateTryCount();

        assertThat(2).isEqualTo(user.getTryCount());
    }
}