package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest extends NsTest {
    InputView inputView = new InputView();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력 받은 다리 길이가 정수가 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings = {"","K", " k ", "1K", "K1"})
    void createBridgeSizeIsChar(String command) {
        assertThatThrownBy(() -> inputView.validateIsNumeric(command))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력 받은 다리 길이가 3~20 사이가 아닌 경우")
    @Test
    void createBridgeSizeRange() {
        assertSimpleTest(() -> {
            runException("45","2","-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("U 또는 D 의외에 이동할 칸을 입력받았을 경우")
    @Test
    void checkMovingPlace() {
        assertSimpleTest(
                () -> {
                    runException("K","45");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("R 또는 Q 의외에 재시작 여부 입력받았을 경우")
    @Test
    void checkInputRetry() {
        assertSimpleTest(
                () -> {
                    runException("K","45","U","D");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
