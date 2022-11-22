package bridge.domain.converter;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("결과 변환기 테스트")
class ResultConverterTest {
    private static final ResultConverter converter = new ResultConverter();

    @DisplayName("OX 변환")
    @ParameterizedTest(name = "{displayName} ({index}) : {1}")
    @MethodSource("paramsForMarkConvert")
    void convertToMark(boolean isCrossable, String correctReturn) {
        assertThat(converter.convertToMark(isCrossable)).isEqualTo(correctReturn);
    }
    private static Stream<Arguments> paramsForMarkConvert() {
        return Stream.of(
                Arguments.of(true, "O"),
                Arguments.of(false, "X")
        );
    }
}