package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameCommandTest {
    @Test
    void 재시작_입력_오류_테스트(){
        //given
        String input = "A";
        //when
        //then
        Assertions.assertThatThrownBy(() -> new GameCommand(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_R_테스트(){
        //given
        String input = "R";
        //when
        GameCommand gameCommand = new GameCommand(input);
        //then
        Assertions.assertThat(gameCommand.getValue()).isEqualTo("R");
    }

    @Test
    void 재시작_입력_Q_테스트(){
        //given
        String input = "Q";
        //when
        GameCommand gameCommand = new GameCommand(input);
        //then
        Assertions.assertThat(gameCommand.getValue()).isEqualTo("Q");
    }
}
