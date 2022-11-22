package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("다리 길이 입력 테스트")
    void readBridgeSize() {
        int result = inputView.readBridgeSize("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 예외 처리")
    void notNumberBridgeSize() {
        int result = inputView.readBridgeSize("15f");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("범위 밖의 길이 예외 처리")
    @ValueSource(strings = {"2", "21", "-100"})
    @ParameterizedTest
    void outOfBoundsBridgeSize(String input) {
        int result = inputView.readBridgeSize(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("이동할 칸 입력 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void readMoving(String input) {
        String result = inputView.readMoving(input);
        assertThat(result).isEqualTo(input);
    }

    @DisplayName("잘못된 값 입력 예외 처리")
    @ValueSource(strings = {"A", "a", "1"})
    @ParameterizedTest
    void unValidEnterMoving(String input) {
        String result = inputView.readMoving(input);
        assertThat(result).isEqualTo(null);
    }

    @DisplayName("재시도 입력 테스트")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void readGameCommand(String input) {
        String result = inputView.readGameCommand(input);
        assertThat(result).isEqualTo(input);
    }

    @DisplayName("잘못된 값 입력 예외 처리")
    @ValueSource(strings = {"A", "a", "1"})
    @ParameterizedTest
    void unValidEnterGameCommand(String input) {
        String result = inputView.readGameCommand(input);
        assertThat(result).isEqualTo(null);
    }

}