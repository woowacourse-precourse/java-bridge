package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        boolean result = inputView.isWrongValue("21",1);
        assertThat(result).isEqualTo(true);
    }



    //사용자 이동 입력값 예외 테스트

    //게임 재시작, 종료 여부 입력값 예외 테스트

}

