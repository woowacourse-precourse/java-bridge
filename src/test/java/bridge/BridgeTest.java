package bridge;

import bridge.Model.Bridge;
import bridge.Model.UserChoice;
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
    void canCrossingTest(String choice, int index, boolean result){
        UserChoice userChoice = new UserChoice(choice);
        boolean actual = bridge.canCrossing(userChoice, index);
        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of("U", 0, true),
                Arguments.of("U", 1, true),
                Arguments.of("D", 2, true),
                Arguments.of("D", 0, false),
                Arguments.of("D", 1, false),
                Arguments.of("U", 2, false)
        );
    }
}
