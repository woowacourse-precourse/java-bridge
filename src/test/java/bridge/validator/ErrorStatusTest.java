package bridge.validator;

import static bridge.validator.ErrorStatus.BRIDGE_SIZE_TYPE_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErrorStatusTest {
    @Test
    @DisplayName("알맞은 형태의 에러 메시지를 반환한다.")
    void isReturnRightFormOfErrorMessage() {
        String errorMessage = BRIDGE_SIZE_TYPE_ERROR.getMessage();

        assertThat(errorMessage).contains("[ERROR]");
    }
}
