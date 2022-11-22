package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Result;
import bridge.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


public class BridgeGameTest {
    BridgeGame game;

    @BeforeEach
    void generateGame() {
        List<String> answerBridge = List.of("U", "D", "U");
        User user = new User();
        Result result = new Result();
        game = new BridgeGame(answerBridge, user, result);
    }

    @DisplayName("moveInput 예외처리 테스트")
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"a", "1", ",", "u", "d"})
    void checkMoveInputException(String input) {
        assertThatThrownBy(() -> game.move(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("move test")
    @ParameterizedTest(name = "input = {0}")
    @CsvSource({"U, true", "D, false"})
    void checkMoveTest(String input, boolean expect) {
        assertThat(game.move(input)).isEqualTo(expect);
    }

    @DisplayName("playResult playing 또는 loose 테스트")
    @ParameterizedTest(name = "input = {0}, expect = {1}")
    @CsvSource({"U, PLAYING", "D, LOOSE"})
    void checkGetPlayResultIsPlaying(String input, String expect) {
        game.move(input);
        assertThat(game.getPlayResult()).isEqualTo(expect);
    }

    @DisplayName("playResult WIN 테스트")
    @Test
    void checkGetPlayResultIsWin() {
        List<String> moveInputs = List.of("U", "D", "U");
        for (String moveInput : moveInputs) {
            game.move(moveInput);
        }
        assertThat(game.getPlayResult()).isEqualTo("WIN");
    }

    @DisplayName("getFinalResult 테스트")
    @Test
    void checkGetFinalResult() {
        game.move("D");
        assertThat(game.getFinalResult()).containsExactly("실패", "1");
    }

    @DisplayName("getFinalResult 성공 테스트")
    @Test
    void checkGetFinalResultIsSuccess() {
        List<String> moveInputs = List.of("U", "D", "U");
        for (String moveInput : moveInputs) {
            game.move(moveInput);
        }
        assertThat(game.getFinalResult()).containsExactly("성공", "1");
    }

    @DisplayName("getFinalResult 시도횟수 테스트")
    @Test
    void checkGetFinalResultTrialTest() {
        game.retry();
        game.move("D");
        assertThat(game.getFinalResult()).containsExactly("실패", "2");
    }
}
