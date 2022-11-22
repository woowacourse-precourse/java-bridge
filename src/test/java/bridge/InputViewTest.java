package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest extends CustomNsTest {

    public static final InputView inputView = new InputView();
    public static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리의 사이즈를 입력받는지 테스트")
    @ValueSource(strings = {"21", "0", "+1", "-1", "05"})
    @ParameterizedTest
    void readBridegeSizeTest(String input) {

            command("21");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("사용자가 이동할 칸을 입력받는지 테스트")
    @ValueSource(strings = {"A", "UU", "DD"})
    @ParameterizedTest
    void readMovingTest(String input) {

        command(input);
        inputView.readMoving();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("사용자가 리트라이 여부를 입력받는지 테스트")
    @ValueSource(strings = {"A", "RR", "QQ"})
    @ParameterizedTest
    void readGameCommand(String input) {

        command(input);
        inputView.readGameCommand();
        assertThat(output()).contains(ERROR_MESSAGE);
    }
}