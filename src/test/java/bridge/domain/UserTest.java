package bridge.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    private User user;

    @BeforeEach
    void beforeEach() {
        user = new User();
    }

    @DisplayName("시도 횟수 getter 테스트")
    @Test
    public void getTryCountTest() {
        //given
        int initialTryCount = 1;

        //when

        //then
        assertThat(user.getTryCount()).isEqualTo(initialTryCount);
    }

    @DisplayName("시도 횟수 증가 테스트")
    @Test
    public void increaseTryCountTest() {
        //given
        int increaseTryCount = 2;

        //when
        user.increaseTryCount();

        //then
        assertThat(user.getTryCount()).isEqualTo(increaseTryCount);
    }

    @DisplayName("게임 종료 및 성공 테스트")
    @Test
    public void isSuccessCompleteTest() {
        //given

        //when
        user.finishWithWin();

        //then
        assertThat(user.isSuccessComplete()).isEqualTo(true);
    }

    @DisplayName("게임 종료 및 실패 테스트")
    @Test
    public void isGameOverTest() {
        //given

        //when
        user.finishWithFail();

        //then
        assertThat(user.isGameOver()).isEqualTo(true);
        assertThat(user.isSuccessComplete()).isEqualTo(false);
    }
}