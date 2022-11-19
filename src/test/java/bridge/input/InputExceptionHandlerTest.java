package bridge.input;

import org.junit.jupiter.api.Test;

import static bridge.input.InputExceptionHandler.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * InputExceptionHandler 클래스와 관련된 테스트 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
class InputExceptionHandlerTest {

    /**
     * 다리의 길이를 입력받는 함수 테스트입니다.
     */
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

    /**
     * 다음 이동할 칸을 입력받는 함수 테스트입니다.
     */
    @Test
    void validateNextCellTest() {
        validateNextCell("U"); // 정상 케이스
        validateNextCell("D"); // 정상 케이스

        // 예외 케이스 - 유효하지 않은 문자 입력
        assertThatThrownBy(() -> validateNextCell("abcde")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 위: U 또는 아래: D를 입력해주세요!");
    }

    /**
     * 재시작 여부를 입력받는 함수 테스트입니다.
     */
    @Test
    void validateRestartInputTest() {
        validateRestartInput("R"); // 정상 케이스
        validateRestartInput("Q"); // 정상 케이스

        // 예외 케이스 - 유효하지 않은 문자 입력
        assertThatThrownBy(() -> validateRestartInput("abcde")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 재시도: R 또는 종료: Q를 입력해주세요!");
    }
}