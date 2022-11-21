package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("다리 개수 입력시 숫자가 아닐 때 예외처리")
    void inputBridgeSizeNotNumber() throws Exception {
        //given
        String input = "1b";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 개수 입력시 범위 초과시 예외처리")
    void inputBridgeSizeOutOfSize() throws Exception {
        //given
        String input = "25";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 개수 입력시 최소값 미달시 예외처리")
    void inputBridgeSizeLess() throws Exception {
        //given
        String input = "2";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 명령 입력시 1글자가 아닐 때 예외처리")
    void inputMoveCommandNotChar() throws Exception {
        //given
        String input = "UU";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputMove(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 명령 입력시 요청 문자와 다를 때 예외처리")
    void inputMoveCommandNotSupport() throws Exception {
        //given
        String input = "Q";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputMove(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시도 명령 입력시 1글자가 아닐 때 예외처리")
    void inputRetryCommandNotChar() throws Exception {
        //given
        String input = "RR";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputRetry(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시도 명령 입력시 요청 문자와 다를 때 예외처리")
    void inputRetryCommandNotSupport() throws Exception {
        //given
        String input = "U";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputRetry(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}