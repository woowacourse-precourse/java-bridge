package bridge.input;

import org.junit.jupiter.api.Test;

import static bridge.input.InputExceptionHandler.validateBridgeLengthInput;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * InputExceptionHandler 클래스와 관련된 테스트 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
class InputExceptionHandlerTest {

    @Test
    void validateBridgeLengthInputTest() {
        validateBridgeLengthInput("1"); // 정상 케이스

        // 예외 케이스 - 문자 입력
        assertThatThrownBy(() -> validateBridgeLengthInput("abcde")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리의 길이는 정수로 입력해주세요!");
        // 예외 케이스 - 0 이하의 정수 입력
        assertThatThrownBy(() -> validateBridgeLengthInput("-1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리의 길이는 1 이상이어야 합니다!");
    }
}