package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {
    private static InputView inputView = new InputView();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이 입력에 문자가 있는 경우 예외가 발생한다.")
    @Test
    void inputBridgeSizeIncludeCharacter() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이 입력이 최소와 최대 사이가 아닌 경우 예외가 발생한다.")
    @Test
    void inputBridgeSizeBetweenMinAndMax() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동 입력 값이 U또는 D가 아닌 경우 예외가 발생한다.")
    @Test
    void inputMovingUpOrDown() {
        assertSimpleTest(() -> {
            runException("3", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("게임 재시작 입력 값이 R또는 Q가 아닌 경우 예외가 발생한다.")
    @Test
    void inputGameCommandRestartOrQuit() {
        assertSimpleTest(() -> {
            runException("3", "U", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        inputView.readBridgeSize();
        inputView.readMoving();
        inputView.readGameCommand();
    }
}
