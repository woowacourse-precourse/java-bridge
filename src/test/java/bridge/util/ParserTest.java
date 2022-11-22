package bridge.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @ParameterizedTest(name = "문자열을 정수로 변환하기")
    @ValueSource(strings = {"-1", "0", "1"})
    void 문자열을_정수로_변환하기(String input) {
        assertDoesNotThrow(() -> Parser.toIntFrom(input));
    }

    @ParameterizedTest(name = "문자열을 정수로 변환 중 예외 발생시키기")
    @ValueSource(strings = {"가", "가1", "1+1"})
    void 문자열을_정수로_변환_중_예외발생_시키기(String input) {
        assertThatThrownBy(() -> Parser.toIntFrom(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}