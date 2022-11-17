package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}