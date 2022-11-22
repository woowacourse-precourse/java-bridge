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
    private List<String> testBridge;

    @BeforeEach
    void initTest() {
        testBridge = Arrays.asList("D", "U", "U", "D");

        bridge = new Bridge(testBridge);
    }

    @DisplayName("bridge 크기 가져오기")
    @Test
    void getBridgeSizeTest() {
        assertThat(bridge.getBridgeSize()).isEqualTo(testBridge.size());
    }

    @DisplayName("현재까지의 입력 값이 다리와 동일한지 확인 - 정답인 경우")
    @MethodSource("generateTruePlayerChoices")
    @ParameterizedTest
    void checkIsAllEqualSoFarIsTrue(List<String> playerChoices) {
        assertThat(bridge.isAllEqualSoFar(playerChoices)).isTrue();
    }

    static Stream<Arguments> generateTruePlayerChoices() {
        return Stream.of(
                Arguments.of(List.of("D")),
                Arguments.of(Arrays.asList("D", "U")),
                Arguments.of(Arrays.asList("D", "U", "U")),
                Arguments.of(Arrays.asList("D", "U", "U", "D"))
        );
    }

    @DisplayName("현재까지의 입력 값이 다리와 동일한지 확인 - 오답인 경우")
    @MethodSource("generateFalsePlayerChoices")
    @ParameterizedTest
    void checkIsAllEqualSoFarIsFalse(List<String> playerChoices) {
        assertThat(bridge.isAllEqualSoFar(playerChoices)).isFalse();
    }

    static Stream<Arguments> generateFalsePlayerChoices() {
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
        List<String> playerChoices = Arrays.asList("D", "U", "U", "D");
        assertThat(bridge.isAllEqualSoFar(playerChoices)).isTrue();
    }

    @DisplayName("최종 사용자 입력 값과 다리가 동일한지 확인 - 오답인 경우")
    @Test
    void checkIsEqualIsFalse() {
        List<String> playerChoices = Arrays.asList("D", "U", "U", "U");
        assertThat(bridge.isAllEqualSoFar(playerChoices)).isFalse();
    }
}
