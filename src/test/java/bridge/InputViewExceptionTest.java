package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewExceptionTest {

    private final InputView inputView;

    InputViewExceptionTest() {
        this.inputView = new InputView();
    }

    //다리 길이 입력값 예외 테스트
    @DisplayName("3~20 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"21,true","20,false","z,true"})
    void checkBridgeSizeException(String input, boolean expected) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        boolean result = inputView.isWrongValue(input,1);
        assertThat(result).isEqualTo(expected);
        if (result){
            assertThat(out.toString()).contains("[ERROR] 3 ~ 20사이 숫자를 입력하여 주세요");

        }
    }


    //사용자 이동 입력값 예외 테스트
    @DisplayName("입력값이 'U','D'가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"e,true","D,false","U,false","2,true"})
    void checkMovingException(String input, boolean expected) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        boolean result = inputView.isWrongValue(input,2);
        assertThat(result).isEqualTo(expected);
        if (result){
            assertThat(out.toString()).contains("[ERROR] 위: U, 아래: D로 입력해야 합니다.");
        }
    }

    //게임 재시작, 종료 여부 입력값 예외 테스트
    @DisplayName("입력값이 'R','Q'가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"t,true","R,false","Q,false","3,true"})
    void checkGameCommandException(String input, boolean expected) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        boolean result = inputView.isWrongValue(input,3);
        assertThat(result).isEqualTo(expected);
        if (result){
            assertThat(out.toString()).contains("[ERROR] 재시도: R,종료: Q로 입력해야 합니다.");
        }
    }
}

