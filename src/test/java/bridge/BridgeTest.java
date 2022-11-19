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
    @MethodSource("provideInvalidLists")
    void createBridgeByInvalidContent(List<String> input) {
        assertThatThrownBy(() -> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidLists() {
        return Stream.of(
                Arguments.of(List.of("U", "D", "P")),
                Arguments.of(List.of("", "", "")),
                Arguments.of(List.of(" ", " ", " ")),
                Arguments.of(List.of("UUU", "D", "D")),
                Arguments.of(List.of("1", "2", "3"))
        );
    }
}
