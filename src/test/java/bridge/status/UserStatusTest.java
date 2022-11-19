package bridge.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 유저_방향에_따른_스코어_가져오기(String direction) {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection(direction);

        String text = userStatus.getUserScoreByDirectionOrElseSpace(direction, 0);

        assertThat(text).isEqualTo(" O ");
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 유저_패배한_상황에서_방향에_따른_스코어_가져오기(String direction) {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection(direction);
        userStatus.lose();

        String text = userStatus.getUserScoreByDirectionOrElseSpace(direction, 0);

        assertThat(text).isEqualTo(" X ");
    }

    @Test
    void 게임을_진행하지_않은_상태에서_유저_최근_방향_조회시_예외발생() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());

        assertThatThrownBy(() -> userStatus.getMostRecentDirection())
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void 유저가_게임에서_승리했을_시_성공_메세지_반환() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("D");
        userStatus.addDirection("D");

        assertThat(userStatus.getStatusMessage()).isEqualTo("게임 성공 여부: 성공");
    }

    @Test
    void 유저가_게임에서_패배시_실패_메세지_반환() {
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("D");
        userStatus.addDirection("D");

        userStatus.lose();
        assertThat(userStatus.getStatusMessage()).isEqualTo("게임 성공 여부: 실패");
    }


}