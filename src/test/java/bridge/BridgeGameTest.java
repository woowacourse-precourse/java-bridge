package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest{

    @Test
    void 칸_이동_확인 () {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);

        assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @Test
    void 칸_이동_확인2 () {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        bridgeGame.passHistory = new ArrayList<>(List.of("U", "D", "U"));

        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }

    @Test
    void 칸_이동_실패_후_종료 () {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        bridgeGame.passHistory = new ArrayList<>(List.of("U", "D", "U"));

        String command = "Q";
        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);

        assertThat(bridgeGame.move("D")).isEqualTo(false);
    }

    @Test
    void 칸_이동_실패_후_재시작() {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        bridgeGame.passHistory = new ArrayList<>(List.of("U", "D", "U"));

        String command = "R";
        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);

        assertThat(bridgeGame.move("D")).isEqualTo(true);
    }
}
