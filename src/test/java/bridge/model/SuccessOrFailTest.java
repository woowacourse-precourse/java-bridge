package bridge.model;

import bridge.util.Constants.Message;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuccessOrFailTest {

    @Test
    void 성공_출력() {
        assertThat(SuccessOrFail.getSuccessOrFailMessage(true)).isEqualTo(Message.SUCCESS_MESSAGE);
    }

    @Test
    void 실패_출력() {
        assertThat(SuccessOrFail.getSuccessOrFailMessage(false)).isEqualTo(Message.FAIL_MESSAGE);
    }
}
