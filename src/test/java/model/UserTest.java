package model;

import static org.assertj.core.api.Assertions.*;

import bridge.BridgeDirect;
import bridge.BridgeStatus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

class UserTest {

    @ParameterizedTest
    @DisplayName("[validateUserInput] 이동할 칸 입력시 user의 입력값이 정확한 경우 테스트")
    @ValueSource(strings = {"U", "D"})
    void correctUserInput(String userInput) {
        //given
        //when
        //then
        assertThatNoException().isThrownBy(()->User.validateUserInput(userInput));
    }

    @ParameterizedTest
    @DisplayName("[validateUserInput] 이동할 칸 입력시 user의 입력값이 U, D 가 아닌경우 예외발생")
    @ValueSource(strings = {"ASD", "Q",".","test"})
    void notCorrectUserInput(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> User.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.STAIRS_U_OR_D);
    }

    @Test
    @DisplayName("[updateUsersInputs] 유저의 input값 업데이트 테스트")
    void updateUsersInput(){
        //given
        User user = new User();
        //when
        user.updateUsersProgress(BridgeDirect.UP, BridgeStatus.CROSS_STATUS);
        //the
        List<UserProgress> userProgress = user.getUserProgress();
        assertThat(userProgress.size()).isEqualTo(1);
        assertThat(userProgress.get(0).getDirect()).isEqualTo(BridgeDirect.UP);
        assertThat(userProgress.get(0).getStatus()).isEqualTo(BridgeStatus.CROSS_STATUS);
    }

    @Test
    @DisplayName("[setRetry] 재시작을 위한 유저상태 초기화 및 재시도 횟수 증가")
    void setRetry() {
        //given
        User user = new User();
        user.updateUsersProgress(BridgeDirect.UP, BridgeStatus.CROSS_STATUS);
        user.updateStatus(UserStatus.END_STATUS);
        //when
        user.setRetry();
        //then
        assertThat(user.getRetryCount()).isEqualTo(2);
        assertThat(user.getUserProgress().size()).isEqualTo(0);
        assertThat(user.getStatus()).isEqualTo(UserStatus.PLAYING_STATUS);
        assertThat(user.getCommand()).isEqualTo(null);
    }

}