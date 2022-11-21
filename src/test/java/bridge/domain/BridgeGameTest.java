package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp(){
        bridgeGame=new BridgeGame(List.of("U","D","D"));
    }

    @DisplayName("bridge에 맞는 값을 입력하면 true를 반환")
    @Test
    void moveWhenInputCorrectReturnTrue() {
        boolean result = bridgeGame.move("U");
        assertThat(result).isTrue();
    }

    @DisplayName("bridge에 틀린 값을 입력하면 false를 반환")
    @Test
    void moveWhenInputIncorrectReturnFalse(){
        boolean result = bridgeGame.move("D");
        assertThat(result).isFalse();
    }

    @DisplayName("bridge에 맞는 값을 입력하면 userMoving에 맞은 결과를 더한다.")
    @Test
    void moveWhenInputCorrectAddCorrectToUserMoving(){
        bridgeGame.move("U");
        List<String> result = bridgeGame.getUserMoving();
        assertThat(result).isEqualTo(List.of("U"));
    }

    @DisplayName("U를 입력했을 때 틀리면 userMoving에 UX를 입력한다.")
    @Test
    void canNotMoveWhenInputU() {
        bridgeGame.canNotMove("U");
        List<String> result = bridgeGame.getUserMoving();
        assertThat(result).isEqualTo(List.of("UX"));
    }

    @DisplayName("D를 입력했을 때 틀리면 userMoving에 DX를 입력한다.")
    @Test
    void canNotMoveWhenInputD(){
        bridgeGame.canNotMove("D");
        List<String> result = bridgeGame.getUserMoving();
        assertThat(result).isEqualTo(List.of("DX"));
    }

    @DisplayName("R을 입력하면 재시작 이라는 뜻이므로 true를 반환")
    @Test
    void retryWhenInputR() {
        boolean retry = bridgeGame.retry("R");
        assertThat(retry).isTrue();
    }

    @DisplayName("Q를 입력하면 false를 반환")
    @Test
    void retryWhenInputQ(){
        boolean retry = bridgeGame.retry("Q");
        assertThat(retry).isFalse();
    }

    @DisplayName("bridgeSize만큼 move하면 마지막 값이 틀려도 True를 반환(isEndOfBridge)")
    @Test
    void isEndOfBridgeWhenLastInputIncorrect() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        boolean retry = bridgeGame.isEndOfBridge();

        assertThat(retry).isTrue();
    }

    @DisplayName("bridgeSize만큼 move하면 True를 반환(isEndOfBridge)")
    @Test
    void isEndOfBridgeWhenLastInputCorrect() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        boolean retry = bridgeGame.isEndOfBridge();

        assertThat(retry).isTrue();
    }

    @DisplayName("bridgeSize만큼 move하지 못하면 False를 반환(isEndOfBridge)")
    @Test
    void isEndOfBridgeWhenLessThanMoveSize() {
        bridgeGame.move("U");
        bridgeGame.move("D");

        boolean retry = bridgeGame.isEndOfBridge();

        assertThat(retry).isFalse();
    }

    @DisplayName("bridgeSize만큼 move하고, 마지막 입력도 맞으면 True반환(isSuccess)")
    @Test
    void isSuccessWhenLastInputCorrect() {

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        boolean retry = bridgeGame.isSuccess();

        assertThat(retry).isTrue();
    }

    @DisplayName("bridgeSize만큼 move했지만, 마지막 값이 틀리면 False반환(isSuccess)")
    @Test
    void isSuccessWhenLastInputIncorrect() {

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        boolean retry = bridgeGame.isSuccess();

        assertThat(retry).isFalse();
    }
}