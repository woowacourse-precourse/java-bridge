package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeTest {
    @DisplayName("다리 길이가 정상인 경우에 대한 테스트")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void correctBridgeSize(String input) {
        Validation validation = new Validation();
        assertFalse(validation.isCheckNotDigit(input));
        assertThatCode(() -> validation.validateBridgeSize(Integer.parseInt(input)))
                .doesNotThrowAnyException();
    }

    @DisplayName("다리 길이가 숫자가 아닌 경우에 대한 예외 테스트")
    @ValueSource(strings = {"삼", "three", " "})
    @ParameterizedTest
    void notDigitBridgeSize(String input) {
        Validation validation = new Validation();
        assertTrue(validation.isCheckNotDigit(input));
    }

    @DisplayName("다리 길이가 3부터 20 사이가 아닌 경우에 대한 예외 테스트")
    @ValueSource(ints = {-2, 1, 30})
    @ParameterizedTest
    void wrongRangeBridgeSize(int input) {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성 테스트")
    @Test
    void createBridge() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).isEqualTo(newArrayList("D", "U", "D"));
    }

    @DisplayName("이동할 칸이 정상인 경우에 대한 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void move(String input) {
        Validation validation = new Validation();
        assertThatCode(() -> validation.validateMove(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동할 칸이 문자가 아닌 경우에 대한 예외 테스트")
    @ValueSource(strings = {"3", " "})
    @ParameterizedTest
    void notCharacterMove(String input) {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.validateMove(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 U 또는 D가 아닌 경우에 대한 예외 테스트")
    @ValueSource(strings = {"u", "up", "위"})
    @ParameterizedTest
    void wrongMove(String input) {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.validateMove(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동경로 생성 테스트")
    @Test
    void createMovingRoute() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> movingRoute = bridgeGame.move(List.of("D", "U", "D"), List.of("D", "U", "U"));
        assertThat(movingRoute).contains(
                "  | O | X",
                "O |   |  "
        );
    }
}