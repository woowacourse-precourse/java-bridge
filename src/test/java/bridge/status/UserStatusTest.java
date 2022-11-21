package bridge.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class UserStatusTest {

    @Test
    void 진행_위치_가져오기() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("U");

        assertThat(userStatus.getPosition()).isZero();
    }

    @Test
    void 가장_최근_방향_가져오기() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("U");

        assertThat(userStatus.getMostRecentDirection()).isEqualTo("U");
    }

    @Test
    void 유저_승패_여부_가져오기() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.lose();

        assertThat(userStatus.isAvailable()).isFalse();
    }

    @Test
    void 유저_재도전_후_상태_확인하기() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.lose();

        userStatus.tryAgain();

        userStatus.addDirection("U");

        assertThat(userStatus.isAvailable()).isTrue();
        assertThat(userStatus.getPosition()).isZero();
        assertThat(userStatus.getMostRecentDirection()).isEqualTo("U");
    }


    @Test
    void 게임을_진행하지_않은_상태에서_유저_최근_방향_조회시_예외발생() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());

        assertThatThrownBy(() -> userStatus.getMostRecentDirection())
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
    

}