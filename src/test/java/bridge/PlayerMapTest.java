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
    private static final PlayerMap successMap = new PlayerMap(
            List.of("O", "O", "O"),
            List.of(" ", " ", " ")
    );

    private static final PlayerMap failureMap = new PlayerMap(
            List.of(" ", " ", " "),
            List.of("X", "X", "X")
    );

    private static Stream<Arguments> subMapTestWithSuccessMapSource() {
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

    @DisplayName("PlayerMap 객체를 알맞는 형식의 문자열로 반환한다")
    @Test
    void toStringsByFormatTest() {
        assertThat(successMap.toStringsByFormat())
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
        assertThat(successMap.isFailure()).isFalse();
    }


    @DisplayName("같은 경로를 가진 두 객체는 동일하다")
    @Test
    void equalsTest() {
        PlayerMap comparedMap = new PlayerMap(
                List.of("O", "O", "O"),
                List.of(" ", " ", " ")
        );
        assertThat(successMap).isEqualTo(comparedMap);
    }

    @DisplayName("다른 경로를 가진 두 객체는 동일하지 않다")
    @Test
    void notEqualsTest() {
        assertThat(successMap).isNotEqualTo(failureMap);
    }

    @DisplayName("successMap의 n번째 칸까지의 subMap을 반환한다")
    @ParameterizedTest
    @MethodSource("subMapTestWithSuccessMapSource")
    void subMapTestWithSuccessMap(int distance, PlayerMap expected) {
        assertThat(successMap.subMapBy(distance))
                .isEqualTo(expected);
    }

    @DisplayName("failureMap에서 n번째 칸의 element를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void elementTestWithFailureMap(int distance) {
        PlayerMap expected = new PlayerMap(List.of(" "), List.of("X"));
        assertThat(failureMap.getElementOf(distance))
                .isEqualTo(expected);
    }


    @DisplayName("successMap과 failureMap을 이어 붙인 객체를 반환한다")
    @Test
    void joinSuccessMapAndFailureMapTest() {
        PlayerMap expected = new PlayerMap(
                List.of("O", "O", "O", " ", " ", " "),
                List.of(" ", " ", " ", "X", "X", "X")
        );

        assertThat(successMap.join(failureMap))
                .isEqualTo(expected);
    }
}
