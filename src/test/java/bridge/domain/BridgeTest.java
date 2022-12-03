package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void initTest() {
        List<String> testBridge = Arrays.asList("D", "U", "U", "D");

        bridge = new Bridge(testBridge);
    }

    @DisplayName("bridge 크기 가져오기")
    @Test
    void getBridgeSizeTest() {
        assertThat(bridge.getBridgeSize()).isEqualTo(4);
    }

    @DisplayName("현재까지의 입력 값이 다리와 동일한지 확인 - 정답인 경우")
    @MethodSource("generateTruePlayerMoves")
    @ParameterizedTest
    void checkIsAllEqualSoFarIsTrue(List<String> playerMoves) {
        assertThat(bridge.isAllEqualSoFar(playerMoves)).isTrue();
    }

    static Stream<Arguments> generateTruePlayerMoves() {
        return Stream.of(
                Arguments.of(List.of("D")),
                Arguments.of(Arrays.asList("D", "U")),
                Arguments.of(Arrays.asList("D", "U", "U")),
                Arguments.of(Arrays.asList("D", "U", "U", "D"))
        );
    }

    @DisplayName("현재까지의 입력 값이 다리와 동일한지 확인 - 오답인 경우")
    @MethodSource("generateFalsePlayerMoves")
    @ParameterizedTest
    void checkIsAllEqualSoFarIsFalse(List<String> playerMoves) {
        assertThat(bridge.isAllEqualSoFar(playerMoves)).isFalse();
    }

    static Stream<Arguments> generateFalsePlayerMoves() {
        return Stream.of(
                Arguments.of(List.of("U")),
                Arguments.of(Arrays.asList("D", "D")),
                Arguments.of(Arrays.asList("D", "U", "D")),
                Arguments.of(Arrays.asList("D", "U", "U", "U"))
        );
    }

    @DisplayName("최종 사용자 입력 값과 다리가 동일한지 확인 - 정답인 경우")
    @Test
    void checkIsEqualIsTrue() {
        List<String> playerMoves = Arrays.asList("D", "U", "U", "D");
        assertThat(bridge.isAllEqualSoFar(playerMoves)).isTrue();
    }

    @DisplayName("최종 사용자 입력 값과 다리가 동일한지 확인 - 오답인 경우")
    @Test
    void checkIsEqualIsFalse() {
        List<String> playerMoves = Arrays.asList("D", "U", "U", "U");
        assertThat(bridge.isAllEqualSoFar(playerMoves)).isFalse();
    }
}
