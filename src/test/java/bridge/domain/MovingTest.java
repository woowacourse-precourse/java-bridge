package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovingTest {
    @Test
    void 다리_건너기_입력_오류_테스트(){
        //given
        String input = "A";
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Moving(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_건너기_입력_U_테스트(){
        //given
        String input = "U";
        //when
        Moving moving = new Moving(input);
        //then
        Assertions.assertThat(moving.getValue()).isEqualTo("U");
    }

    @Test
    void 다리_건너기_입력_D_테스트(){
        //given
        String input = "D";
        //when
        Moving moving = new Moving(input);
        //then
        Assertions.assertThat(moving.getValue()).isEqualTo("D");
    }
}
