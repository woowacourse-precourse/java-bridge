package bridge.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserUtilTest {

    @DisplayName("다리 길이 입력값으로 3부터 20까지 정수 외 문자열을 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1", "2", "21", "a", "#"})
    void parserBridgeSize(String input){
        assertThatThrownBy(() -> {
            ParserUtil.parseBridgeSize(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 이동 방향으로 'U'나 'D'가 아닌 값을 입력하면 오류 발생")
    @ParameterizedTest
    @ValueSource (strings = {"", "1","u", "d"})
    void parseMovement(String input) {
        assertThatThrownBy(() -> {
            ParserUtil.parseMovement(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재도전 의사 입력값이 'R'이나 'Q'가 아닐 경우 오류 발생")
    @ParameterizedTest
    @ValueSource (strings = {"", "1", "u", "@"})
    void parseRetryCommandInput(String input) {
        assertThatThrownBy(() -> {
            ParserUtil.parseGameCommand(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}