package bridge.path;

import bridge.command.Movement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PathTest {

    private static final EnumMap<Result, String> format = new EnumMap<>(
            Map.ofEntries(
                    Map.entry(Result.PREFIX, "[ "),
                    Map.entry(Result.SUFFIX, " ]"),
                    Map.entry(Result.DELIMITER, " | "),
                    Map.entry(Result.O, "O"),
                    Map.entry(Result.X, "X"),
                    Map.entry(Result.UNSELECTED, " ")
            )
    );

    @DisplayName("format")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "'UP, DOWN, DOWN, DOWN', 'UP, DOWN, DOWN, DOWN', '[ O |   |   |   ]\n[   | O | O | O ]'",
            "'UP, DOWN, DOWN, UP', 'UP, DOWN, DOWN, UP', '[ O |   |   | O ]\n[   | O | O |   ]'",
            "'UP, DOWN, DOWN, UP', 'UP, DOWN, DOWN, DOWN', '[ O |   |   |   ]\n[   | O | O | X ]'"
    })
    void format(
            final String rawlyActualMovements,
            final String rawlyExpectedMovements,
            final String expectedFormat
    ) {
        final List<Movement> actualMovements = parseMovements(rawlyActualMovements);
        final List<Movement> expectedMovements = parseMovements(rawlyExpectedMovements);
        final Path path = Path.of(actualMovements, expectedMovements);

        final String actualFormat = path.format(format);
        assertThat(actualFormat).isEqualTo(expectedFormat);
    }

    @DisplayName("searchesFailed")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "'UP, DOWN, DOWN, DOWN', 'UP, DOWN, DOWN, DOWN', false",
            "'UP, DOWN, DOWN, UP', 'UP, DOWN, DOWN, UP', false",
            "'UP, DOWN, DOWN, UP', 'UP, DOWN, DOWN, DOWN', true"
    })
    void searchesFailed(
            final String rawlyActualMovements,
            final String rawlyExpectedMovements,
            final boolean expectedResult
    ) {
        final List<Movement> actualMovements = parseMovements(rawlyActualMovements);
        final List<Movement> expectedMovements = parseMovements(rawlyExpectedMovements);
        final Path path = Path.of(actualMovements, expectedMovements);

        final boolean actualResult = path.searchesFailed();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    private List<Movement> parseMovements(String rawMovements) {
        return Arrays.stream(rawMovements.split(", "))
                .map(Movement::valueOf)
                .collect(Collectors.toList());
    }
}