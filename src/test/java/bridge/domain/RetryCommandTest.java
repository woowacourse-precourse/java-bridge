package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RetryCommandTest {

    @Test
    void 문자_R_혹은_Q_전달하여_생성() {
        //given
        //when
        RetryCommand retryCommand = RetryCommand.of('R');
        //then
        assertThat(retryCommand).isEqualTo(RetryCommand.RETRY);
    }

    @Test
    void 문자_R_혹은_Q_아니면_예외발생() {
        assertThatThrownBy(() -> RetryCommand.of('a'))
                .isInstanceOf(IllegalArgumentException.class);
    }
}