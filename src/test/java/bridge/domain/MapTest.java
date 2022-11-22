package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MapTest {
    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(List.of(true, true, true, true), List.of(
                                List.of("[ O ]",
                                        "[   ]"),
                                List.of("[ O |   ]",
                                        "[   | O ]"),
                                List.of("[ O |   | O ]",
                                        "[   | O |   ]"),
                                List.of("[ O |   | O |   ]",
                                        "[   | O |   | O ]")),
                        "4번 모두 성공"),
                Arguments.of(List.of(true, false), List.of(
                                List.of("[ O ]",
                                        "[   ]"),
                                List.of("[ O |   ]",
                                        "[   | X ]")),
                        "2번째에서 실패"),
                Arguments.of(List.of(true, true, false), List.of(
                                List.of("[ O ]",
                                        "[   ]"),
                                List.of("[ O |   ]",
                                        "[   | O ]"),
                                List.of("[ O |   | X ]",
                                        "[   | O |   ]")),
                        "3번째에서 실패"
                )
        );
    }

    @DisplayName("길이가 4인 다리에 대해 지도 생성")
    @MethodSource("provideArguments")
    @ParameterizedTest(name = "{index}: {2}")
    void testGenerateMap(List<Boolean> isAnswers, List<List<String>> maps, String message) {
        List<String> commands = new ArrayList<>(List.of("U", "D", "U", "D"));
        validateSameLengths(isAnswers, maps);
        Map map = new Map();
        for (int i = 0; i < isAnswers.size(); i++) {
            map.update(commands.get(i), isAnswers.get(i));
            assertThat(map.getCurrentMap()).isEqualTo(maps.get(i));
        }
    }

    private void validateSameLengths(List<Boolean> isAnswers, List<List<String>> maps) {
        if (isAnswers.size() != maps.size()) {
            throw new IllegalArgumentException("commands, isAnswers, maps의 길이가 동일해야 합니다.");
        }
    }
}