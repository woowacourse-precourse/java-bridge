package bridge.outputView;

import bridge.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputViewTest extends NsTest {


    OutputView outputView = new OutputView();

    @MethodSource("provideParameters")
    @ParameterizedTest
    void printMapTest(String printedMap1, String printedMap2, Integer countOfMove, Boolean isMove) {
        List<String> bridge = new ArrayList<String>(List.of("U", "D", "D", "U"));
        outputView.printMap(bridge, countOfMove, isMove);
        assertThat(output()).contains(printedMap1, printedMap2);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("[ O |   |   | O ]", "[   | O | O |   ]", 3, true),
                Arguments.of( "[ O |   |   | X ]", "[   | O | O |   ]", 3, false),
                Arguments.of( "[ O |   ]", "[   | X ]", 1, false)
        );
    }

    @Override
    protected void runMain() {
    }
}
