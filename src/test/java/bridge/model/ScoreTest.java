package bridge.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @DisplayName("유저가 선택한 다리로 지나갈 수 있다.")
    @ParameterizedTest
    @CsvSource({"U, UDD", "D, DDD"})
    void canGo(String userStep, String bridge) {
        assertThat(score.goOneStep(new Bridge(List.of(bridge.split(""))), userStep)).isTrue();
    }

    @DisplayName("유저가 선택한 다리로 지나갈 수 없다.")
    @ParameterizedTest
    @CsvSource({"D, UDD", "U, DDD"})
    void canNotGo(String userStep, String bridge) {
        assertThat(score.goOneStep(new Bridge(List.of(bridge.split(""))), userStep)).isFalse();
    }

    @DisplayName("유저가 다리를 건넜으면 true를 리턴한다.")
    @ParameterizedTest
    @MethodSource("listProviderIsCrossing")
    void isCrossing(List<String> userStep, List<String> bridge) {
        assertTrue(new Score(new UserStep(userStep)).isCrossing(new Bridge(bridge)));
    }

    static Stream<Arguments> listProviderIsCrossing() {
        return Stream.of(
                arguments(List.of("U", "D", "D", "D", "D", "D", "D", "D", "D"),
                        List.of("U", "D", "D", "D", "D", "D", "D", "D", "D")),
                arguments(List.of("D", "D", "D", "D", "D", "D"), List.of("D", "D", "D", "D", "D", "D"))
        );
    }

    @DisplayName("유저가 다리를 건너지 않았으면 false를 리턴한다.")
    @ParameterizedTest
    @MethodSource("listProviderIsNotCrossing")
    void isNotCrossing(List<String> userStep, List<String> bridge) {
        assertFalse(new Score(new UserStep(userStep)).isCrossing(new Bridge(bridge)));
    }

    static Stream<Arguments> listProviderIsNotCrossing() {
        return Stream.of(
                arguments(List.of("U", "D", "D", "D", "D"), List.of("U", "D", "D", "D", "D", "D", "D", "D", "D")),
                arguments(List.of("D", "D", "D", "D"), List.of("D", "D", "D", "D", "D", "D"))
        );
    }

    @DisplayName("R을 입력하면 유저가 지나온 정보가 초기화 된다.")
    @Test
    void judgeRetryThenIsRetry() {
        Score newScore = new Score(new UserStep(List.of("U", "D")));
        assertEquals("R", newScore.judgeRetry("R"));
        this.score.judgeRetry("R");
        assertThat(newScore).isEqualTo(this.score);
    }

    @DisplayName("Q를 입력하면 초기화 되지 않는다.")
    @Test
    void judgeRetryThenIsNotRetry(){
        Score newScore = new Score(new UserStep(List.of("U", "D")));
        assertEquals("Q", newScore.judgeRetry("Q"));
        assertThat(newScore).isNotEqualTo(new Score());
    }
}