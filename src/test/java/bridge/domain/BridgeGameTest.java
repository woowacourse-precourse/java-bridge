package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void initTest() {
        List<String> testBridge = Arrays.asList("D", "U", "U", "D");

        Bridge bridge = new Bridge(testBridge);
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("move 테스트 - 정답이 아닌 값 입력")
    @Test
    void moveTestWrongMovement() {
        String expect = "[ X ]\n[   ]\n";
        assertThat(bridgeGame.move("U")).isEqualTo(expect);
        assertThat(bridgeGame.isFinish()).isTrue();
        assertThat(bridgeGame.isSuccess()).isFalse();
    }

    @DisplayName("move 테스트 - 정답 값 입력")
    @Test
    void moveTestCorrectMovement() {
        String expect = "[   ]\n[ O ]\n";
        assertThat(bridgeGame.move("D")).isEqualTo(expect);
        assertThat(bridgeGame.isFinish()).isFalse();
        assertThat(bridgeGame.isSuccess()).isFalse();
    }

    @DisplayName("move 테스트 - 예외 값 입력")
    @ValueSource(strings = {"E", "u", "d", "1", ".", "", " "})
    @ParameterizedTest
    void moveTestExceptionMovement(String inputValue) {
        assertThatThrownBy(() -> bridgeGame.move(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("isSuccess 테스트 - 성공인 경우")
    @Test
    void isSuccessTest() {
        List<String> inputValues = Arrays.asList("D", "U", "U", "D");
        String result = "";
        String expect = "[   | O | O |   ]\n[ O |   |   | O ]\n";

        for (String inputValue : inputValues) {
            result = bridgeGame.move(inputValue);
        }

        assertThat(result).isEqualTo(expect);
        assertThat(bridgeGame.isFinish()).isTrue();
        assertThat(bridgeGame.isSuccess()).isTrue();
    }

    @DisplayName("isSuccess 테스트 - 실패인 경우")
    @Test
    void isFailTest() {
        List<String> inputValues = Arrays.asList("D", "U", "U", "U");
        String result = "";
        String expect = "[   | O | O | X ]\n[ O |   |   |   ]\n";

        for (String inputValue : inputValues) {
            result = bridgeGame.move(inputValue);
        }

        System.out.println(result);
        assertThat(result).isEqualTo(expect);
        assertThat(bridgeGame.isFinish()).isTrue();
        assertThat(bridgeGame.isSuccess()).isFalse();
    }
}
