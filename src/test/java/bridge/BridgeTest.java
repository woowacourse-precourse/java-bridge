package bridge;

import bridge.Model.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeTest {

    @DisplayName("잘못된 값으로 다리를 생성하는 테스트")
    @ParameterizedTest
    @MethodSource({"provideInvalidContentLists", "provideInvalidSizeLists"})
    void createBridgeByInvalidContent(List<String> input) {
        assertThatThrownBy(() -> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidContentLists() {
        return Stream.of(
                Arguments.of(List.of("U", "D", "P")),
                Arguments.of(List.of("u", "d", "d")),
                Arguments.of(List.of("", "", "")),
                Arguments.of(List.of(" ", " ", " ")),
                Arguments.of(List.of("UUU", "D", "D")),
                Arguments.of(List.of("1", "2", "3"))
        );
    }

    private static Stream<Arguments> provideInvalidSizeLists() {
        return Stream.of(
                Arguments.of(List.of("U", "D")),
                Arguments.of(List.of(
                        "U", "D", "U", "D",
                        "D", "D", "D", "U",
                        "D", "U", "D", "U",
                        "U", "D", "D", "U",
                        "D", "D", "D", "U",
                        "D"))
        );
    }
}
