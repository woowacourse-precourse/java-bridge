package bridge;

import bridge.game.BridgeGame;
import bridge.status.PassOrNot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class BridgeGameTest {
    int index = 0;
    @ParameterizedTest
    @CsvSource({"U,U,O", "D,D,O", "U,D,X", "D,U,X"})
    void 다리_각_칸의_값과_입력값을_비교하는_기능_일치할때_테스트(String value,String input, String answer) {
        List<String> list = List.of(value);
        BridgeGame bridgeGame = new BridgeGame(list);

        PassOrNot result = bridgeGame.move(input, index);
        Assertions.assertThat(result.getValue()).isEqualTo(answer);
    }
}