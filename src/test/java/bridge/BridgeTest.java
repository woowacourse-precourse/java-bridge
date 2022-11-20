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
    void canCrossingTest(String choice, int index, ChoiceResult result){
        UserChoice userChoice = new UserChoice(choice);
        ChoiceResult actual = bridge.canCrossing(userChoice, index);
        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of("U", 0, ChoiceResult.SUCCESS),
                Arguments.of("U", 1, ChoiceResult.SUCCESS),
                Arguments.of("D", 2, ChoiceResult.SUCCESS),
                Arguments.of("D", 0, ChoiceResult.FAIL),
                Arguments.of("D", 1, ChoiceResult.FAIL),
                Arguments.of("U", 2, ChoiceResult.FAIL)
        );
    }
}
