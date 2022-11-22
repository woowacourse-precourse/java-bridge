package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameConditionTest {

    @DisplayName("R은 재시작을 의미한다.")
    @Test
    void conditionRestart() {
        //given
        String condition = "R";

        //when
        GameCondition restart = GameCondition.RESTART;

        //then
        assertThat(restart.getCondition()).isEqualTo(condition);
    }

    @DisplayName("Q는 종료를 의미한다.")
    @Test
    void conditionQuit() {
        //given
        String condition = "Q";

        //when
        GameCondition quit = GameCondition.QUIT;

        //then
        assertThat(quit.getCondition()).isEqualTo(condition);
    }

    @DisplayName("존재하는 조건이면 해당 조건을 반환한다.")
    @Test
    void getCondition() {
        //given
        GameCondition condition = GameCondition.RESTART;
        String input = condition.getCondition();

        //when
        GameCondition result = GameCondition.from(input);

        //then
        assertThat(result).isEqualTo(condition);
    }

    @DisplayName("존재하지 않는 조건이면 예외가 발생한다.")
    @ValueSource(strings = {"1", "@", " ", "u", "가"})
    @ParameterizedTest
    void getConditionWithException(String input) {
        //then
        assertThatThrownBy(() -> GameCondition.from(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

}