package bridge.domain;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMatcherTest {

    private BridgeMatcher bridgeMatcher;
    private List<Boolean> boolBridge;

    @BeforeEach
    void setUp() {
        boolBridge = newArrayList(true, true, false);
        bridgeMatcher = new BridgeMatcher(boolBridge, 1);
    }

    @Test
    @DisplayName("입력값의 일치여부를 모아둔 Collection의 길이 기능 테스트")
    void calculateSize() {
        int expected = 3;

        int actual = bridgeMatcher.calculateSize();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값의 일치여부를 추가하는 기능 테스트")
    void addTrueOrFalse() {
        List<Boolean> expected = newArrayList(true, true, false, true);

        bridgeMatcher.addTrueOrFalse(true);
        Assertions.assertThat(boolBridge).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateTestBridge")
    @DisplayName("게임 성공 여부를 확인하는 기능 테스트")
    void isGameSuccess(List<Boolean> matchedBridge, List<String> bridge, boolean expected) {
        bridgeMatcher = new BridgeMatcher(matchedBridge, 1);
        boolean actual = bridgeMatcher.isGameSuccess(bridge);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateTestBridge() {
        return Stream.of(
                Arguments.of(newArrayList(true, true, true), Arrays.asList("D", "D", "D"), true),
                Arguments.of(newArrayList(true, true, true, false), Arrays.asList("U", "U", "U", "U"), false)
        );
    }
}