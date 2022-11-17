package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 이동_로그_테스트(){
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.move("U", "U");
        bridgeGame.move("U", "U");
        bridgeGame.move("U", "U");
        bridgeGame.move("U", "D");
        char[][] answer = {{'O', 'O', 'O', ' '}, {' ', ' ', ' ', 'X'}};
        assertThat(bridgeGame.log).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"U:U:true","U:D:false","D:D:true","D:U:false"}, delimiter = ':')
    void 이동에_따른_생존여부_변경_테스트(String answer, String submit, boolean result) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(answer,submit);
        assertThat(bridgeGame.survival).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"R:true","Q:false"}, delimiter = ':')
    void 입력에_따른_게임_재시작_여부_테스트(char input, boolean answer) {
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.retry(input)).isEqualTo(answer);
    }
}