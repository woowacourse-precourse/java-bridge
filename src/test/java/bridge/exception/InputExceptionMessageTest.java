package bridge.exception;

import org.junit.jupiter.api.Test;

import static bridge.exception.InputExceptionMessage.INPUT_NOT_FIND_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

public class InputExceptionMessageTest {
    @Test
    void 에러_메시지_반환_테스트() {
        assertThat(INPUT_NOT_FIND_EXCEPTION.message()).isEqualTo("[ERROR] 입력 값이 존재하지 않습니다.");
    }
}
