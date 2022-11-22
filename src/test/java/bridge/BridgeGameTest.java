package bridge;

import bridge.Instances.EndType;
import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static bridge.Instances.EndType.FAIL_QUIT;
import static bridge.Instances.EndType.FAIL_RETRY;
import static org.assertj.core.api.Assertions.assertThat;


public class BridgeGameTest {

    @DisplayName("움직였을 때 position 테스트")
    @Test
    void positionTest() {
        int position = 1;
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(1, position, bridge, "U");
        final byte[] buf = String.join("\n", "D").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        bridgeGame.move();
        assertThat(bridgeGame).extracting("position").isEqualTo(position + 1);
    }


    @DisplayName("재시작 시 다리 구성 동일한지 테스트")
    @Test
    void sameBridgeTest() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(1, 0, bridge, "");
        final byte[] buf = String.join("\n", "U", "D", "D", "R", "U").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        bridgeGame.moveUntilGameOver();
        EndType type = bridgeGame.gameEnded();
        bridgeGame.successEndOrFailEnd(type);
        bridgeGame.move();
        assertThat(bridgeGame).extracting("bridge").isEqualTo(bridge);
    }


    @DisplayName("게임 재시작 테스트")
    @Test
    void retryTest() {
        List<String> bridge = List.of("U", "D", "U");
        final byte[] buf = String.join("\n", "U", "D", "D", "R").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        BridgeGame bridgeGame = new BridgeGame(1, 0, bridge, "");
        bridgeGame.moveUntilGameOver();
        EndType type = bridgeGame.gameEnded();
        bridgeGame.successEndOrFailEnd(type);
        assertThat(type).isEqualTo(FAIL_RETRY);
        assertThat(bridgeGame).extracting("trial").isEqualTo(2);
        assertThat(bridgeGame).extracting("position").isEqualTo(0);
    }

    @DisplayName("게임 종료 테스트")
    @Test
    void quitTest(){
        List<String> bridge = List.of("U", "D", "U");
        final byte[] buf = String.join("\n", "U", "D", "D", "Q").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        BridgeGame bridgeGame = new BridgeGame(1, 0, bridge, "");
        bridgeGame.moveUntilGameOver();
        EndType type = bridgeGame.gameEnded();
        bridgeGame.successEndOrFailEnd(type);
        assertThat(type).isEqualTo(FAIL_QUIT);
    }
}
