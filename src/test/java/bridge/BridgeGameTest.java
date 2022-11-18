package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;
    @BeforeEach
    void 선언부() {
        bridgeGame = new BridgeGame();
    }


    @Test
    void 이동_로그_테스트(){
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
        bridgeGame.move(answer,submit);
        assertThat(bridgeGame.survival).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"R:true","Q:false"}, delimiter = ':')
    void 입력에_따른_게임_재시작_여부_테스트(String input, boolean answer) {
        assertThat(bridgeGame.retry(input)).isEqualTo(answer);
    }
}