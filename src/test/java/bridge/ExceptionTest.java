package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("문자를 입력받을 시 오류 발생")
    void 문자를_입력받을_시_오류_발생(){
        String input = "rkatk";
        assertThatThrownBy(() -> inputView.readBridgeSizeOfNoNumberException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력을 받습니다.");
    }

    @Test
    @DisplayName("숫자의 범위를 벗어날 경우, 오류 발생")
    void 숫자의_범위를_벗어날_경우_오류_발생(){
        String input = "32";
        assertThatThrownBy(() -> inputView.readScopeOfBridgeSizeOfNumberException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("사용자의 요청이 올바르지 않으면 오류 발생")
    void 사용자의_요청이_올바르지_않으면_오류_발생(){
        String input = "I";
        assertThatThrownBy(() -> inputView.readMovingCommandCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] U와 R 중에 하나를 입력하세요.");
    }
}
