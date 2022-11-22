package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeStringGeneratorTest {
    @Test
    void 성공시_다리_출력_테스트() {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        String result = "[ O ]\n[   ]\n";
        //when
        String testResult = bridgeGame.toString();
        //then
        assertThat(testResult).isEqualTo(result);
    }

    @Test
    void 실패시_다리_출력_테스트() {
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("D");
        String result = "[   ]\n[ X ]\n";
        //when
        String testResult = bridgeGame.toString();
        //then
        assertThat(testResult).isEqualTo(result);
    }
}
