package bridge.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserUtilTest {

    @DisplayName("다리 길이 입력값 예외 테스트")
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

}