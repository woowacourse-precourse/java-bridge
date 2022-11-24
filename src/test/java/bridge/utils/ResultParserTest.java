package bridge.utils;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultParserTest {

    private final ResultParser resultParser = new ResultParser();

    @DisplayName("결과값에 따라 올바른 출력 String을 반환한다.")
    @MethodSource("provideInputForOutput")
    @ParameterizedTest
    void givenGameResultReturnOutputString(GameResult result, String expected) {
        String parsedResult = resultParser.parseResultToMapUI(result);
        assertThat(parsedResult).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputForOutput() { // argument source method
        List<String> bridge = new ArrayList<>(List.of("U", "D", "U"));
        String one = "[ O |   |   ]\n[   | O | X ]";
        String two = "[ O |   | O ]\n[   | O |   ]";
        return Stream.of(
                Arguments.of(GameResult.of(bridge, ViewStatus.DETERMINE_RETRY), one),
                Arguments.of(GameResult.of(bridge, ViewStatus.DETERMINE_MOVE), two)
        );
    }
}