package bridge.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.dto.BridgeGameDto;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

public class OutputViewTest extends PrintTestTool {

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(PrintMapTestData.class)
    void printMapTest(List<String> bridge, List<String> route, List<String> excepted) {
        BridgeGameDto dto = new BridgeGameDto(bridge, route, 1);

        new OutputView().printMap(dto);

        assertThat(output()).contains(excepted);
    }

    static class PrintMapTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of("U","U","U","D"), List.of("U","U"),
                            List.of("[ O | O ]", "[   |   ]")),
                    Arguments.of(List.of("U","U","D"), List.of("U","U","D"),
                            List.of("[ O | O |   ]", "[   |   | O ]")),
                    Arguments.of(List.of("U","U","U","D"), List.of("U","D"),
                            List.of("[ O |   ]", "[   | X ]"))
            );
        }
    }

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(PrintResultTest.class)
    void printResultTest(BridgeGameDto dto, List<String> excepted) {
        new OutputView().printResult(dto);

        assertThat(output()).contains(excepted);
    }

    static class PrintResultTest implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new BridgeGameDto(List.of("U","U","U","D"), List.of("U","U","U","D"), 3),
                            List.of("게임 성공 여부: 성공", "총 시도한 횟수: 3")),
                    Arguments.of(new BridgeGameDto(List.of("U","U","D"), List.of("U","U","D"), 20),
                            List.of("게임 성공 여부: 성공", "총 시도한 횟수: 20")),
                    Arguments.of(new BridgeGameDto(List.of("U","U","U","D"), List.of("U","D"),13),
                            List.of("게임 성공 여부: 실패", "총 시도한 횟수: 13"))
            );
        }
    }

}
