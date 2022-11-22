package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMapMakerTest {

    private static final List<String> bridge = List.of("U", "D", "D");
    private static final PlayerMapMaker playerMapMaker = new PlayerMapMaker(new BridgeMapMaker(bridge));

    @DisplayName("n번째 칸으로 이동한 후 다리 건너기를 성공했을 때의 경로를 반환한다")
    @ParameterizedTest
    @MethodSource("makeSuccessPlayerMapTestSource")
    void makeSuccessPlayerMapTest(int distance, PlayerMap expected) {
        assertThat(playerMapMaker.makeSuccessPlayerMapTo(distance))
                .isEqualTo(expected);
    }

    @DisplayName("n번째 칸으로 이동한 후 다리 건너기를 실패했을 때의 경로를 반환한다")
    @ParameterizedTest
    @MethodSource("makeFailurePlayerMapTestSource")
    void makeFailurePlayerMapTest(int distance, PlayerMap expected) {
        assertThat(playerMapMaker.makeFailurePlayerMapTo(distance))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> makeSuccessPlayerMapTestSource() {
        return Stream.of(
                Arguments.of(1, new PlayerMap(
                        List.of("O"),
                        List.of(" ")
                )),
                Arguments.of(2, new PlayerMap(
                        List.of("O", " "),
                        List.of(" ", "O")
                )),
                Arguments.of(3, new PlayerMap(
                        List.of("O", " ", " "),
                        List.of(" ", "O", "O")
                ))
        );
    }

    private static Stream<Arguments> makeFailurePlayerMapTestSource() {
        return Stream.of(
                Arguments.of(1, new PlayerMap(
                        List.of(" "),
                        List.of("X")
                )),
                Arguments.of(2, new PlayerMap(
                        List.of("O", "X"),
                        List.of(" ", " ")
                )),
                Arguments.of(3, new PlayerMap(
                        List.of("O", " ", "X"),
                        List.of(" ", "O", " ")
                ))
        );
    }
}
