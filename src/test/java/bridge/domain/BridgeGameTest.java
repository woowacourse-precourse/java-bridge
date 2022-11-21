package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp(){
        bridgeGame=new BridgeGame(List.of("U","D","D"));
    }

    @DisplayName("맞는 값을 입력하면 true, 틀린 값을 입력하면 false")
    @ParameterizedTest
    @CsvSource({"U,true","D,false"})
    public void move(String userInput, boolean expected){
        boolean actual = bridgeGame.move(userInput);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("bridge에 맞는 값을 입력하면 userMoving에 맞은 결과를 더한다.")
    @Test
    void moveWhenInputCorrectAddCorrectToUserMoving(){
        bridgeGame.move("U");
        List<String> result = bridgeGame.getUserMoving();
        assertThat(result).isEqualTo(List.of("U"));
    }

    @DisplayName("U가 틀리면 UX, D가 틀리면 DX를 userMoving에 추가")
    @ParameterizedTest
    @CsvSource({"U,UX","D,DX"})
    void canNotMove(String userInput, String expected){
        bridgeGame.canNotMove(userInput);
        List<String> actual = bridgeGame.getUserMoving();
        assertThat(actual.get(0)).isEqualTo(expected);
    }

    @DisplayName("R을 입력하면 재시작(true), Q를 입력하면 종료(false)")
    @ParameterizedTest
    @CsvSource({"R,true","Q,false"})
    void retry(String userInput, boolean expected){
        boolean actual = bridgeGame.retry(userInput);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("bridgeSize만큼 move하면 true, bridgeSize만큼 move하지 못하면 false")
    @ParameterizedTest
    @CsvSource({"U,D,U,true","U,D,D,true","U,D,' ',false"})
    void isEndOfBridge(String userInput1, String userInput2, String userInput3, boolean expected){
        bridgeGame.move(userInput1);
        bridgeGame.move(userInput2);
        bridgeGame.move(userInput3);
        boolean actual = bridgeGame.isEndOfBridge();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("끝까지 가고 마지막이 맞으면 true, 마지막이 틀리면 false")
    @ParameterizedTest
    @CsvSource({"U,D,D,true","U,D,U,false"})
    void isSuccess(String userInput1, String userInput2, String userInput3, boolean expected){
        bridgeGame.move(userInput1);
        bridgeGame.move(userInput2);
        bridgeGame.move(userInput3);
        boolean actual = bridgeGame.isSuccess();

        assertThat(actual).isEqualTo(expected);
    }
}