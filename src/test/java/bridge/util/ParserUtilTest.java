package bridge.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1", "2", "21", "a", "#"})
    @DisplayName("다리 길이 입력값 예외 테스트")
    void parserBridgeSize(String input){
        assertThatThrownBy( () -> {
            ParserUtil.parseBridgeSize(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}