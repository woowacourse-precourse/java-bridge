package bridge.constant;

import static bridge.constant.ErrorResponse.NOT_FOUND_DIRECTION;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorResponseTest {

    @Test
    void 등록해둔_예외_메시지와함께_반환성공() throws Exception {
        RuntimeException exception = NOT_FOUND_DIRECTION.getException();
        Assertions.assertThat(exception.getMessage())
            .isEqualTo("[ERROR] 위, 아래 방향 외의 방향은 찾을 수 없습니다.");
    }

}