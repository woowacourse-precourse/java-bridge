package bridge.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static bridge.domain.Command.QUIT;
import static bridge.domain.Command.RETRY;
import static bridge.support.ErrorMessage.INVALID_COMMAND_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CommandTest {

    @Test
    void from_R이_들어오는_경우_RETRY를_리턴한다() {
        //given
        String code = "R";

        //when
        Command res = Command.from(code);

        //then
        assertThat(res).isEqualTo(RETRY);
    }

    @Test
    void from_Q가_들어오는_경우_QUIT를_리턴한다() {
        //given
        String code = "Q";

        //when
        Command res = Command.from(code);

        //then
        assertThat(res).isEqualTo(QUIT);
    }

    @Test
    void from_R_또는_Q_이외의_값이_들어오는_경우_예외가_발생한다() {
        //given
        String code = "G";

        //when then
        assertThatThrownBy(() -> Command.from(code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COMMAND_ERROR);
    }
}