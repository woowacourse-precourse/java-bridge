package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMapTest {
    private static final PlayerMap playerMap1 = new PlayerMap(
            List.of("O", "O", "O"),
            List.of(" ", " ", " ")
    );
    private static final PlayerMap playerMap2 = new PlayerMap(
            List.of("O", "O", "O"),
            List.of(" ", " ", " ")
    );
    private static final PlayerMap failureMap = new PlayerMap(
            List.of(" ", "O", " "),
            List.of("O", " ", "X")
    );

    @DisplayName("PlayerMap 객체를 알맞는 형식의 문자열로 반환한다")
    @Test
    void toStringsByFormatTest() {
        assertThat(playerMap1.toStringsByFormat())
                .isEqualTo(List.of(
                        "[ O | O | O ]",
                        "[   |   |   ]"
                ));
    }

    @DisplayName("X를 포함한 경로는 true를 반환한다")
    @Test
    void failureTest() {
        assertThat(failureMap.isFailure()).isTrue();
    }

    @DisplayName("X를 포함하지 않은 경로는 false를 반환한다")
    @Test
    void notFailureTest() {
        assertThat(playerMap1.isFailure()).isFalse();
    }

    @DisplayName("playerMap1의 n번째 칸까지의 subMap을 반환한다")
    @ParameterizedTest
    @MethodSource("subMapTestSource")
    void subMapTest(int distance, PlayerMap expected) {
        assertThat(playerMap1.subMapBy(distance))
                .isEqualTo(expected);
    }

    @DisplayName("playerMap1에서 n번째 칸의 element를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void elementTest(int distance) {
        PlayerMap expected = new PlayerMap(List.of("O"), List.of(" "));
        assertThat(playerMap1.getElementOf(distance))
                .isEqualTo(expected);
    }

    @DisplayName("successMap과 failureMap을 이어 붙인 객체를 반환한다")
    @Test
    void joinTest() {
        PlayerMap expected = new PlayerMap(
                List.of("O", "O", "O", " ", "O", " "),
                List.of(" ", " ", " ", "O", " ", "X")
        );
        assertThat(playerMap1.join(failureMap))
                .isEqualTo(expected);
    }

    @DisplayName("같은 경로를 가진 playerMap1과 playerMap2는 동일하다")
    @Test
    void equalsTest() {
        assertThat(playerMap1).isEqualTo(playerMap2);
    }

    @DisplayName("다른 경로를 가진 playerMap1과 failureMap은 동일하지 않다")
    @Test
    void notEqualsTest() {
        assertThat(playerMap1).isNotEqualTo(failureMap);
    }

    @DisplayName("같은 경로를 가진 playerMap1과 playerMap2는 동일한 해시코드를 가진다")
    @Test
    void sameHashCodeTest() {
        assertThat(playerMap1.hashCode())
                .isEqualTo(playerMap2.hashCode());
    }

    @DisplayName("다른 경로를 가진 playerMap1과 failureMap은 다른 해시코드를 가진다")
    @Test
    void differentHashCodeTest() {
        assertThat(playerMap1.hashCode())
                .isNotEqualTo(failureMap.hashCode());
    }

    private static Stream<Arguments> subMapTestSource() {
        return Stream.of(
                Arguments.of(1, new PlayerMap(
                        List.of("O"),
                        List.of(" ")
                )),
                Arguments.of(2, new PlayerMap(
                        List.of("O", "O"),
                        List.of(" ", " ")
                )),
                Arguments.of(3, new PlayerMap(
                        List.of("O", "O", "O"),
                        List.of(" ", " ", " ")
                ))
        );
    }
}
