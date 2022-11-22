package bridge.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private static InputView inputView;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
    }

    @DisplayName("다리 길이 사용자 입력값 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2", "-1", "21", "hihi", "안녕"})
    void readBridgeSizeExceptionTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 시 사용자 입력값 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"q", "r", "hihi", "안녕"})
    void readGameCommandExceptionTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

}