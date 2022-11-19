package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeMaker;
import java.util.List;
import org.assertj.core.api.Assertions;
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
        String userInput = BridgeMaker.UP_STAIRS;
        //when
        user.updateUsersInputs(userInput);
        //the
        List<String> userInputs = user.getUserInputs();
        assertThat(userInputs.size()).isEqualTo(1);
        assertThat(userInputs.get(userInputs.size() - 1)).isEqualTo(BridgeMaker.UP_STAIRS);
    }

    @Test
    @DisplayName("[updateUsersStatus] 유저의 status(다리 건너기 성공여부 List) 업데이트 테스트")
    void updateUsersStatus(){
        //given
        User user = new User();
        //when
        user.updateUsersStatus(User.NOT_CROSS_STATUS);
        //the
        List<String> useStatus = user.getUsersStatus();
        assertThat(useStatus.size()).isEqualTo(1);
        assertThat(useStatus.get(useStatus.size() - 1)).isEqualTo(User.NOT_CROSS_STATUS);
    }
}