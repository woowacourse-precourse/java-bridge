package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("입력 받은 다리 길이 3이상 20이하의 숫자가 아니면 오류")
    @ParameterizedTest
    @ValueSource(strings = {"1", "abc", "21", "2", "23", " ", ""})
    void NumberRange3over20under(String input) {
        Assertions.assertThatThrownBy(()->
                        bridgeGame.init(input))
                            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 다리 길이는 3이상 20이하의 숫자 확인")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20", "15", "10", "4", "19"})
    void NumberRange3over20underOK(String input) {
        assertDoesNotThrow(()->
                bridgeGame.init(input));
    }

    @DisplayName("입력 받은 이동 방향이 \"U\" 와 \"D\" 둘 중 하나가 아니면 오류")
    @ParameterizedTest
    @ValueSource(strings = {"A", "UU", " ", "UD", "1D", "Z"})
    void moveDirection(String direction) {
        Assertions.assertThatThrownBy(()->
                bridgeGame.move(direction))
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 이동 방향이 \"U\" 와 \"D\" 둘 중 하나")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void moveDirectionOK(String direction) throws NoSuchFieldException, IllegalAccessException {
        Field bridge = bridgeGame.getClass().getDeclaredField("bridge");
        bridge.setAccessible(true);
        List<String> answerBridge = List.of("U","D","D");
        bridge.set(bridgeGame,new Bridge(answerBridge));
        assertDoesNotThrow(()->
                bridgeGame.move(direction));
    }

    @DisplayName("입력 받은 이동 방향이 \"R\"와 \"D\" 둘 중 하나가 아니면 오류")
    @ParameterizedTest
    @ValueSource(strings = {"A","RR", "12", "QQQ", "abc", "a", "RQ"})
    void retryOptionInput(String select) {
        Assertions.assertThatThrownBy(()->
                bridgeGame.retry(select))
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 이동 방향이 \"R\" 와 \"Q\" 둘 중 하나")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void retryOptionInputOK(String select) {
        assertDoesNotThrow(()->
                bridgeGame.retry(select));
    }
}