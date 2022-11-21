package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("입력 받은 다리 길이 3이상 20이하의 숫자가 아니면 오류")
    @ParameterizedTest
    @ValueSource(strings = {"1", "abc", "21", "2", " ", ""})
    void NumberRange3over20under(String input) {
        Assertions.assertThatThrownBy(()->
                bridgeGame.init(input))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
    }

    @Test
    void isRightDirection() {
    }

    @Test
    void getResult() {
    }

    @Test
    void retry() {
    }
}