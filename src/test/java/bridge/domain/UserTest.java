package bridge.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("시도 횟수 getter 테스트")
    @Test
    public void getTryCountTest() {
        //given

        //when
        User user = new User();

        //then
        assertThat(user.getTryCount()).isEqualTo(1);
    }


    @DisplayName("시도 횟수 증가 테스트")
    @Test
    public void increaseTryCountTest() {
        //given
        User user = new User();

        //when
        user.increaseTryCount();

        //then
        assertThat(user.getTryCount()).isEqualTo(2);
    }

    @DisplayName("게임 종료 및 성공 테스트")
    @Test
    public void isSuccessCompleteTest() {
        //given
        User user = new User();

        //when
        user.finishWithWin();

        //then
        assertThat(user.isSuccessComplete()).isEqualTo(true);
    }

    @DisplayName("게임 실패 테스트")
    @Test
    public void isNotSuccessCompleteTest() {
        //given

        //when
        User user = new User();

        //then
        assertThat(user.isSuccessComplete()).isEqualTo(false);
    }


    @DisplayName("게임 종료 및 실패 테스트")
    @Test
    public void isGameOverTest() {
        //given
        User user = new User();

        //when
        user.finishWithFail();

        //then
        assertThat(user.isGameOver()).isEqualTo(true);
    }
}