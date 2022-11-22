package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import inputUtil.ConsoleInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest extends NsTest {

    ConsoleInput consoleInput = new ConsoleInput();

    @DisplayName("사용자로부터 다리의 크기를 입력받는 출력이 정상적인지 확인")
    @Test
    void 사용자가_다리의_크기를_입력() {
        consoleInput.setInput("3");
        InputView.readBridgeSize();
        assertThat(output()).contains("다리 길이를 입력해주세요.");
    }
    @DisplayName("사용자가 숫자가 아닌 값을 입력하였을 때 예외 발생")
    @Test
    void 사용자가_숫자가_아닌_문자열을_입력했을떄_예외발생() {
        consoleInput.setInput("errorString");
        assertThatThrownBy(InputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리의 개수는 숫자만 입력해야 합니다.");
    }

    @Test
    void readMoving() {
        consoleInput.setInput("U");
        InputView.readMoving();
        assertThat(output()).contains("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    @Test
    void readGameCommand() {
        consoleInput.setInput("R");
        InputView.readGameCommand();
        assertThat(output()).contains("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    @Override
    protected void runMain() {

    }
}