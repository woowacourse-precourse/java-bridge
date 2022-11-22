package bridge.outputView;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputViewTest extends NsTest {

    OutputView outputView = new OutputView();

    @DisplayName("한 칸씩 움직일 때마다의 출력 테스트 코드")
    @MethodSource("provideParametersForPrintMap")
    @ParameterizedTest
    void printMapTest(String printedMap1, String printedMap2, Integer countOfMove, Boolean isMove) {
        List<String> bridge = new ArrayList<String>(List.of("U", "D", "D", "U"));
        outputView.setBridge(bridge);
        outputView.printMap(countOfMove, isMove);
        assertThat(output()).contains(printedMap1, printedMap2);
    }

    @DisplayName("최종 결과에 대한 출력 테스트")
    @MethodSource("provideParametersForPrintResult")
    @ParameterizedTest
    void printResultTest(List<String> printedMap, Integer countOfMove, Boolean isSuccess, Integer countOfPlay) {
        List<String> bridge = new ArrayList<String>(List.of("U", "D", "D", "U"));
        outputView.setBridge(bridge);
        outputView.printResult(countOfMove, isSuccess, countOfPlay);
        String successMessage = "성공";
        if (!isSuccess) {
            successMessage = "실패";
        }
        assertThat(output()).contains(
                printedMap.get(0),
                printedMap.get(1),
                successMessage,
                countOfPlay.toString());
    }

    private static Stream<Arguments> provideParametersForPrintMap() {
        return Stream.of(
                Arguments.of("[ O |   |   | O ]", "[   | O | O |   ]", 3, true),
                Arguments.of( "[ O |   |   | X ]", "[   | O | O |   ]", 3, false),
                Arguments.of( "[ O |   ]", "[   | X ]", 1, false)
        );
    }

    private static Stream<Arguments> provideParametersForPrintResult() {
        return Stream.of(
                Arguments.of(List.of("[ O |   |   | O ]", "[   | O | O |   ]"), 3, true, 3),
                Arguments.of( List.of("[ O |   |   | X ]", "[   | O | O |   ]"), 3, false, 2),
                Arguments.of( List.of("[ O |   ]", "[   | X ]"), 1, false, 2)
        );
    }

    @Override
    protected void runMain() {
    }
}
