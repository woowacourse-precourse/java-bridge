package bridge;

import bridge.Enum.CrossResult;
import bridge.Model.WrappingType.Bridge;
import bridge.Model.WrappingType.ChoiceDirection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

public class BridgeTest {
    private Bridge bridge = new Bridge(List.of("U", "U", "D"));

    @ParameterizedTest
    @MethodSource("generateData")
    void canCrossingTest(String choice, int index, CrossResult result) {
        ChoiceDirection userChoice = new ChoiceDirection(choice);
        CrossResult actual = bridge.cross(userChoice, index);
        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("U", 0, CrossResult.SUCCESS),
                Arguments.of("U", 1, CrossResult.SUCCESS),
                Arguments.of("D", 2, CrossResult.SUCCESS),
                Arguments.of("D", 0, CrossResult.FAIL),
                Arguments.of("D", 1, CrossResult.FAIL),
                Arguments.of("U", 2, CrossResult.FAIL)
        );
    }
}
