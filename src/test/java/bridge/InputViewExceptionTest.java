package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    void inputWrongBridgeSize() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        boolean result = inputView.isWrongValue("21",1);
        assertThat(result).isEqualTo(true);
        assertThat(out.toString()).contains("[ERROR] 3 ~ 20사이 숫자를 입력하여 주세요");
    }



    //사용자 이동 입력값 예외 테스트

    //게임 재시작, 종료 여부 입력값 예외 테스트

}

