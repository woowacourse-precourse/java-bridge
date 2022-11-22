package bridge.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameCommandTest {

    @Test
    void 게임_커멘드_문자() throws Exception {
        //given
        String command = "R";

        //when

        //then
        Assertions.assertThat(GameCommand.generate(command))
                .isEqualTo(GameCommand.RESTART);

    }
    @Test
    void 게임_커멘드_문자_예외() throws Exception {
        //given
        String command = "X";

        //when

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> GameCommand.generate(command));
    }

    @Test
    void 게임_커멘드_검증_예외() throws Exception {
        //given
        String command = "X";

        //when

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> GameCommand.validateInput(command));

    }

    @Test
    void 게임_커멘드_재시작() throws Exception {
        //given
        GameCommand command = GameCommand.RESTART;

        //when
        boolean isRestart = GameCommand.isRestart(command);

        //then
        Assertions.assertThat(isRestart)
                .isTrue();
    }

    @Test
    void 게임_커멘드_재시작_예외() throws Exception {
        //given
        GameCommand command = GameCommand.QUIT;

        //when
        boolean isRestart = GameCommand.isRestart(command);

        //then
        Assertions.assertThat(isRestart)
                .isFalse();
    }
}