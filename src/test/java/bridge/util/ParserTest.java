package bridge.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @ParameterizedTest(name = "문자열을 정수로 변환 테스트")
    @ValueSource(strings = {"-1", "0", "1"})
    void 문자열을_정수로_변환(String input) {
        assertDoesNotThrow(() -> Parser.toIntFrom(input));
    }

    @ParameterizedTest(name = "문자열을 정수로 변환 예외 테스트")
    @ValueSource(strings = {"가", "가1", "1+1"})
    void 문자열을_정수로_변환_예외(String input) {
        assertThatThrownBy(() -> Parser.toIntFrom(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}