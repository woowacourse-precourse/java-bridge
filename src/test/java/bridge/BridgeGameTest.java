package bridge;

import bridge.Controller.BridgeGameController;
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
    static List<String> bridge = List.of("U", "D", "U");

    @DisplayName("움직였을 때 position 테스트")
    @Test
    void positionTest() {
        int position = 1;
        BridgeGame bridgeGame = new BridgeGame(1, position, bridge, "U");
        putCommand("D");
        bridgeGame.move("D");
        assertThat(bridgeGame).extracting("position").isEqualTo(position + 1);
    }


    @DisplayName("재시작 시 다리 구성 동일한지 테스트")
    @Test
    void sameBridgeTest() {
        BridgeGame bridgeGame = new BridgeGame(1, 0, bridge, "");
        putCommand("U", "D", "D", "R", "U");
        playRoundEndType(bridgeGame);
        bridgeGame.move("U");
        assertThat(bridgeGame).extracting("bridge").isEqualTo(bridge);
    }


    @DisplayName("게임 재시작 테스트")
    @Test
    void retryTest() {
        putCommand("U", "D", "D", "R");
        BridgeGame bridgeGame = new BridgeGame(1, 0, bridge, "");
        EndType type = playRoundEndType(bridgeGame);
        assertThat(type).isEqualTo(FAIL_RETRY);
        assertThat(bridgeGame).extracting("trial").isEqualTo(2);
        assertThat(bridgeGame).extracting("position").isEqualTo(0);
    }

    @DisplayName("게임 종료 테스트")
    @Test
    void quitTest() {
        putCommand("U", "D", "D", "Q");
        BridgeGame bridgeGame = new BridgeGame(1, 0, bridge, "");
        EndType type = playRoundEndType(bridgeGame);
        assertThat(type).isEqualTo(FAIL_QUIT);
    }

    void putCommand(String... command) {
        final byte[] buf = String.join("\n", command).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    EndType playRoundEndType(BridgeGame bridgeGame) {
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGame);
        bridgeGameController.moveUntilGameOver();
        EndType type = bridgeGameController.gameEnded();
        bridgeGameController.printResultCheckRetry(type);
        return type;
    }


}
