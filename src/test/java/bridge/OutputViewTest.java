package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class OutputViewTest extends CustomNsTest {

    private final OutputView outputView = new OutputView();

    /////////////////////////////////////////////////////////////////////////////////////////////
    static List<List<List<String>>> printMapTestParameter() {
        return List.of(
                List.of(
                        List.of("O", " ", "O"),//"[ O |   | O ]"
                        List.of(" ", "O", " ") //"[   | O |   ]"
                ),
                List.of(
                        List.of("O", "O", "O"),//"[ O | O | O ]"
                        List.of(" ", " ", " ") //"[   |   |   ]"
                ),
                List.of(
                        List.of(" ", " ", " "),//"[   |   |   ]"
                        List.of("O", "O", "O") //"[ O | O | O ]"
                ),
                List.of(
                        List.of("O", " "), //"[ O |   ]"
                        List.of(" ", "X")  //"[   | X ]"
                )
        );
    }

    //클래스 하나 만들어 놓자
    @DisplayName("현재 다리 상황 출력 테스트")
    @MethodSource("printMapTestParameter")
    @ParameterizedTest
    void printMapTest(final List<List<String>> bridge) {
        final List<String> upSide = bridge.get(0);
        final List<String> downSide = bridge.get(1);
        final String upSideBridge = upSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        final String downSideBridge = upSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));

        outputView.printMap(upSide, downSide);
        assertThat(output()).contains(
                upSideBridge,
                downSideBridge
        );
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

    static List<List<String>> printResultTestParameter() {
        return List.of(
                List.of(
                        "[ O |   | O ]",
                        "[   | O |   ]"
                ),
                List.of(
                        "[ O | O | O ]",
                        "[   |   |   ]"
                ),
                List.of(
                        "[   |   |   ]",
                        "[ O | O | O ]"
                )
        );
    }

    @DisplayName("최종 결과 출력 테스트")
    @MethodSource("printResultTestParameter")
    @ParameterizedTest
    void printResultTest(List<String> bridge) {
        int count = 2;
        outputView.printResult(bridge.get(0), bridge.get(1), count);
        assertThat(output()).contains(
                "최종 게임 결과",
                bridge.get(0),
                bridge.get(1),
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
        );
    }
    ////////////////////////////////////////////////////////////////////////////////////////
}