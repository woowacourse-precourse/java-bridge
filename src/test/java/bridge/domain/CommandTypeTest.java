package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTypeTest {


    @Test
    @DisplayName("Q,R 이 아닌 값을 인자로받으면 예외 발생")
    public void 예외테스트() {
        assertThatThrownBy(() -> CommandType.create("U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] Q 또는 R 를 입력해야 합니다.");
    }
    @Test
    @DisplayName("Q,R 을 인자로받으면 해당하는 CommandType 이 생성 되어야 한다.")
    public void 생성테스트() {
        //given
        String quitInput = "Q";
        String restartInput = "R";
        //when
        CommandType quit = CommandType.create(quitInput);
        CommandType restart = CommandType.create(restartInput);
        //then
        assertThat(quit).isEqualTo(CommandType.QUIT);
        assertThat(restart).isEqualTo(CommandType.RESTART);
    }

}