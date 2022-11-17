package bridge.exception;

import bridge.constant.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilClassCreateExceptionTest {
    @Test
    @DisplayName("유틸 클래스 생성 시 발생하는 예외")
    void utilClassCreateException() {
        assertThatThrownBy(() -> {
            throw new UtilClassCreateException();
        })
                .isInstanceOf(UtilClassCreateException.class)
                .hasMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
}